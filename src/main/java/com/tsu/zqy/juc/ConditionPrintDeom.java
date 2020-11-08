package com.tsu.zqy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionPrintDeom
 * @Author Elv1s
 * @Date 2020/10/25 12:00
 * @Description:
 */
public class ConditionPrintDeom {
    public static void main(String[] args) {
        ThreadData threadData = new ThreadData();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                threadData.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                threadData.printLi();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                threadData.printBaBa();
            }
        }, "C").start();
    }

    static class ThreadData {
        volatile int flag = 0;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        void printA() {
            lock.lock();
            try {
                // 判断
                while (flag != 0) {
                    condition1.await();
                }
                // 执行
                System.out.print("A");
                //通知
                flag = 1;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void printLi() {
            lock.lock();
            try {
                // 判断
                while (flag != 1) {
                    condition2.await();
                }
                // 执行
                System.out.print("Li");
                //通知
                flag = 2;
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void printBaBa() {
            lock.lock();
            try {
                // 判断
                while (flag != 2) {
                    condition3.await();
                }
                // 执行
                System.out.println("Baba");
                //通知
                flag = 0;
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
