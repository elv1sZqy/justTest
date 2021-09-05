package com.tsu.zqy.jvm;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadStackTest
 * @Author Elv1s
 * @Date 2021/9/1 20:35
 * @Description:
 */
public class ThreadStackTest {

    public static void test(int i) {
        if (i <= 2000) {
            test(++i);
        } else {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i : " + i);
            }
        }
    }
    public static void main(String[] args){
        System.out.println("1111");
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setNameFormat("just test - %d");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1024, 1024, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024),
                threadFactoryBuilder.build());

        for (int i = 0; i < 1024; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                test(0);
               /* while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i : " + finalI);
                }*/
            });
        }
    }

}
