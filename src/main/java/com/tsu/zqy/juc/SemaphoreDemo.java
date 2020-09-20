package com.tsu.zqy.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @ClassName SemaphoreDemo
 * @Author Elv1s
 * @Date 2020/2/29 14:41
 * @Description:
 */
public class SemaphoreDemo {

    public static void main(String[] args){
        int i = 8;
        ThreadFactory demo = new ThreadFactoryBuilder().setNameFormat("demo").build();
        // 8个人  2个厕所(信号量)
        Semaphore  semaphore= new Semaphore(2);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(i, i, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(i), demo, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int j = 0; j < i; j++) {
            final int index = j;
            poolExecutor.execute(()->{
                doSomeThing(semaphore,index);
            });
        }
        poolExecutor.shutdown();
    }

    private static void doSomeThing(Semaphore semaphore, int index) {
        System.out.println(index +"用户尝试上厕所");
        try {
            semaphore.acquire();
            System.out.println(index+"开始上厕所");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(index+"离开厕所");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
