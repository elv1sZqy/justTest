package com.tsu.zqy.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTaskTest
 * @Author Elv1s
 * @Date 2020/10/25 16:24
 * @Description:
 */
public class FutureTaskTest {

    static class MyTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int i = new Random().nextInt(100);
            System.out.println(Thread.currentThread().getName() + "计算得数字:" + i);
            return i;
        }
    }

    public static void main(String[] args){
        MyTask myTask = new MyTask();
        // 同一个任务即使新建了两个线程,但是只会跑一次
        FutureTask<Integer> futureTask = new FutureTask<>(myTask);
        new Thread(futureTask, "AAA").start();
        new Thread(futureTask, "bbb").start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
