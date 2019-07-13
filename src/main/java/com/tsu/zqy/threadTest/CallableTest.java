package com.tsu.zqy.threadTest;

import java.util.concurrent.*;

/**
 * @ClassName CallableTest
 * @Author Elv1s
 * @Date 2019/6/19 12:07
 * @Description:
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableImpl cb1 = new CallableImpl(0, 1000);
        CallableImpl cb2 = new CallableImpl(10, 20);
        CallableImpl cb3 = new CallableImpl(5, 10);

        /* 方式1
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> result = executor.submit(cb1);
        System.out.println(result.get());
        executor.shutdown();
        */

        /*方式二
        FutureTask<Integer> result1 = new FutureTask<>(cb1);
        new Thread(result1).start();
        System.out.println(result1.get());*/

       /* 方式三
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> result1 = new FutureTask<>(cb1);
        executor.submit(result1);
        executor.shutdown();
        System.out.println(result1.get());*/

       /* 方式三
       ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result1 = executor.submit(cb1);
        Future<Integer> result2 = executor.submit(cb2);
        Future<Integer> result3 = executor.submit(cb3);

        executor.shutdown();*/

        FutureTask<Integer> result1 = new FutureTask<>(cb1);
        FutureTask<Integer> result2 = new FutureTask<>(cb2);
        FutureTask<Integer> result3 = new FutureTask<>(cb3);
        Thread thread3 = new Thread(result1, "线程3");
        thread3.start();
        thread3.join();
        Thread thread2 = new Thread(result2, "线程2");
        thread2.start();
        //thread2.join();
        Thread thread1 = new Thread(result3, "线程1");
        thread1.start();
        //thread1.join();

        System.out.println("主线程完成");

       /* System.out.println("线程1" + Thread.currentThread().getName() + "  " + result1.get() + "  " + result1.isDone());
        System.out.println(Thread.currentThread().getName() + "  " + result2.get());
        System.out.println(Thread.currentThread().getName() + "  " + result3.get());

        System.out.println(" sum = " + (result1.get() + result2.get() + result3.get()));*/



/*
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
            Thread.sleep(1);
        }*/


    }

}
