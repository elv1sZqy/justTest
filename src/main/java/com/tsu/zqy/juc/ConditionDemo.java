package com.tsu.zqy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionDemo
 * @Author Elv1s
 * @Date 2020/3/1 14:43
 * @Description:
 */
public class ConditionDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    private static int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            product();
        }).start();
        new Thread(() -> {
            consumer();
        }).start();
    }

    private static void consumer() {
        try {
            while (true) {
                lock.lock();
                --count;
                System.out.println("消费了一个,还剩:" +count);
                if (count < 1) {
                    System.out.println("开始唤醒消费者.....");

                    empty.signal();
                    try {
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }

    }

    private static void product() {
        try {
            lock.lock();
            while (true) {
                ++count;
                System.out.println("生产了一个,还剩:" +count);
                if (count > 20) {
                    try {
                        System.out.println("开始唤醒消费者.....");
                        full.signal();
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        } finally {
            lock.unlock();
        }
    }

}
