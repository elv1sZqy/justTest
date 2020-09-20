package com.tsu.zqy.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @ClassName CountDownLatchDemo
 * @Author Elv1s
 * @Date 2020/2/29 14:03
 * @Description:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int i = 5;
        ThreadFactory demo = new ThreadFactoryBuilder().setNameFormat("demo").build();
        CountDownLatch countDownLatch = new CountDownLatch(i);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(i, i, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(i), demo, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int j = 0; j < i; j++) {
            final int index = j;
            poolExecutor.execute(()->{
                doSomeThing(countDownLatch, index);
            });
        }
        countDownLatch.await();
        System.out.println("所有线程都执行完成了");
        poolExecutor.shutdown();
    }

    private static void doSomeThing(CountDownLatch countDownLatch, int j) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 线程开始执行" + j);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name + "执行完成");
            countDownLatch.countDown();
        }
    }
}
