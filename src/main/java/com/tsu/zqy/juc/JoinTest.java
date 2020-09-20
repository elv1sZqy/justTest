package com.tsu.zqy.juc;

/**
 * @ClassName JoinTest
 * @Author Elv1s
 * @Date 2020/3/1 11:09
 * @Description:   底层其实是调用了wait方法, 实现的线程有序执行
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("线程1执行");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("线程2执行");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("线程3执行");
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }

}
