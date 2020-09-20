package com.tsu.zqy.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RefusePolicy
 * @Author Elv1s
 * @Date 2020/3/1 11:12
 * @Description:
 */
public class RefusePolicy {

    public static void main(String[] args) {
       /* ThreadPoolExecutor abortPolicyPoolExecutor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());
        // 三个任务,  一个交给核心线程, 一个放入任务队列,  因为多了一个就抛异常了
        for (int i = 0; i < 3; i++) {
            final int index = i;
            abortPolicyPoolExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index);
            });

        }*/

     /*   ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
        // 拒绝队列中最旧任务 ,保留最后加入的任务    输出就会是 0    3
        for (int i = 0; i < 4; i++) {
            final int index = i;
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index);
            });*/
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy());
        // 拒绝队列中最新任务 ,保留最先加入的任务    输出就会是 0    1
        for (int i = 0; i < 4; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index);
            });*/
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1, 2, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.CallerRunsPolicy());
        // 任务都会被执行
        /*
        main2
        pool-1-thread-10
        main3
        pool-1-thread-11
         */
        // 主线程也会执行任务                这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功。
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor1.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + index);
            });
        }
    }

}
