package com.tsu.zqy.juc.threadpool;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName MyThreadPool
 * @Author Elv1s
 * @Date 2020/3/15 10:44
 * @Description:
 */
public class MyThreadPool {

    private volatile int coreThreadCount;
    private volatile int maxThreadCount;

    private BlockingQueue<Runnable> queue;

    public MyThreadPool(int coreThreadCount, int maxThreadCount, BlockingQueue queue) {
        this.coreThreadCount = coreThreadCount;
        this.maxThreadCount = maxThreadCount;
        this.queue = queue;
    }

    public void execute(Runnable task) {
        addWork(task);
    }

    private void addWork(Runnable task) {
        Worker woker = new Worker(task);
        woker.thread.start();
    }


    class Worker implements Runnable{

        private Thread thread;
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
            this.thread = new Thread(this);
        }

        @Override
        public void run() {
            runWork(this);
        }

        private void runWork(Worker worker) {
            Runnable task = worker.task;
            task.run();
        }

    }
}
