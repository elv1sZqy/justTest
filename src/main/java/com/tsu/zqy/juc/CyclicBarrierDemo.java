package com.tsu.zqy.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName CyclicBarrierDemo
 * @Author Elv1s
 * @Date 2020/2/29 14:22
 * @Description:
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        int i = 5;
        ThreadFactory demo = new ThreadFactoryBuilder().setNameFormat("demo").build();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(i);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(i, i, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(i), demo, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int j = 0; j < i; j++) {
            final int index = j;
            poolExecutor.execute(()->{
                doSomeThing(cyclicBarrier,index);
            });
        }
        System.out.println("第一场比赛准备开始.....");


        for (int j = 0; j < i; j++) {
            final int index = j;
            poolExecutor.execute(()->{
                doSomeThing(cyclicBarrier,index);
            });
        }

        poolExecutor.shutdown();
    }

    private static void doSomeThing(CyclicBarrier cyclicBarrier, int index) {
        try {
            Random random = new Random();
            int i = random.nextInt(10);
            Thread.sleep(i*1000);
            System.out.printf("%d号选手已经就位",index);
            System.out.println();
            cyclicBarrier.await();
            System.out.println("3");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("2");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("0");
            System.out.printf("%d号选手起跑",index);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
