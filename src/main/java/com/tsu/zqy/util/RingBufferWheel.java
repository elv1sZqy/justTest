package com.tsu.zqy.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuQiYun
 * @create 2021/2/4
 * @description :
 */
public class RingBufferWheel {

    private static int DEFAULT_RING_BUFFER_SIZE = 64;

    private Object[] ringBuffer;

    private int bufferSize;

    private ExecutorService executorService;

    private AtomicInteger taskSize = new AtomicInteger();

    private volatile boolean stop = false;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    RingBufferWheel(ExecutorService executorService) {
        this.executorService = executorService;
        bufferSize = DEFAULT_RING_BUFFER_SIZE;
        ringBuffer = new Object[bufferSize];
    }

    RingBufferWheel(ExecutorService executorService, Integer bufferSize) {
        this.executorService = executorService;
        this.bufferSize = bufferSize;
        ringBuffer = new Object[bufferSize];
    }

    public void addTask(Task task) {
        int key = task.getKey();
        task.caculateCycleNum(bufferSize);
        key = key % bufferSize;
        task.setKey(key);
        Set<Task> tasks = getTasks(key);
        if (null == tasks) {
            tasks = new CopyOnWriteArraySet<>();
            tasks.add(task);
            putTasks(key, tasks);
        } else {
            tasks.add(task);
        }
        taskSize.incrementAndGet();
    }

    public Set<Task> removeTask(int key) {
        Set<Task> tasks = getTasks(key);
        Set<Task> executorTasks = null;
        if (CollectionUtils.isNotEmpty(tasks)) {
            executorTasks = new CopyOnWriteArraySet<>();
            Set<Task> tempTasks = new CopyOnWriteArraySet<>();
            for (Task task : tasks) {
                int cycleNum = task.getCycleNum();
                if (0 == cycleNum) {
                    executorTasks.add(task);
                } else {
                    cycleNum -= 1;
                    task.setCycleNum(cycleNum);
                    tempTasks.add(task);
                }
            }
            putTasks(key, tempTasks);
        }
        size2Notify();
        return executorTasks;
    }

    private void size2Notify() {
        if (0 == taskSize.get()) {
            this.lock.lock();
            condition.signal();
            lock.unlock();
        }
    }

    public void stop(boolean force) {
        if (force) {
            stop = true;
            executorService.shutdown();
        } else {
            try {
                this.lock.lock();
                condition.await();
                stop = true;
                executorService.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void start() {
        System.out.println("#### 开始执行时间轮");
        int index = 0;
        while (!stop) {

            // 执行任务
            Set<Task> tasks = removeTask(index);
            if (CollectionUtils.isNotEmpty(tasks)) {
                for (Task task : tasks) {
                    executorService.execute(() -> task.runTask());
                    taskSize.addAndGet(-1);
                }
            }

            // 重置index
            if (++index > bufferSize - 1) {
                index = 0;
            }

            // 停止一秒执行
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentTaskSize() {
        return taskSize.get();
    }

    private Set<Task> getTasks(int key) {
        return (Set<Task>) ringBuffer[key];
    }

    private void putTasks(int key, Set<Task> tempTasks) {
        ringBuffer[key] = tempTasks;
    }

    public static class Task {
        /**
         * 在环中的索引
         */
        private int key;

        /**
         * 剩余圈数
         */
        private Integer cycleNum;

        public void runTask() {
            System.out.println(this.key + "----" + this.cycleNum);
        }

        public int getKey() {
            return this.key;
        }

        public Task setKey(final int key) {
            this.key = key;
            return this;
        }

        public Task setCycleNum(int cycleNum) {
            this.cycleNum = cycleNum;
            return this;
        }

        public Task caculateCycleNum(int bufferSize) {
            this.cycleNum = (this.key) / bufferSize;
            return this;
        }

        public Integer getCycleNum() {
            return this.cycleNum;
        }
    }

}
