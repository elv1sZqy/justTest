package com.tsu.zqy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionDemo
 * @Author Elv1s
 * @Date 2020/3/1 14:43
 * @Description:
 */
public class ConditionDemo2 {


    static Lock lock = new ReentrantLock();
    final static Condition condition1 = lock.newCondition();
    final static Condition condition2 = lock.newCondition();
    final static Condition condition3 = lock.newCondition();
    private volatile int state = 0;


    public static void main(String[] args) {
        ConditionDemo2 conditionTest = new ConditionDemo2();

        new Thread(() -> {
            conditionTest.printA("A", 0, 1, condition1, condition2);
        }).start();

        new Thread(() -> {
            conditionTest.printA("B", 1, 2, condition2, condition3);
        }).start();

        new Thread(() -> {
            conditionTest.printA("C", 2, 0, condition3, condition1);
        }).start();
    }

    /**
     * @param s                打印的字符串内容
     * @param inParameter      初始化的state入参值
     * @param expectNextState  控制打印顺序的开关 让对应的哪个线程执行打印
     * @param currentCondition 由于3个condition 会创建3个阻塞队列 代表当前condition所对应的那个阻塞队列
     * @param nextCondition    通知我们规定的那个线程 从对应的等待队列里进入同步队列中 获取锁 执行打印
     */
    public void printA(String s, int inParameter, int expectNextState, Condition currentCondition, Condition nextCondition) {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (state != inParameter) {
                    currentCondition.await();
                }
                System.out.println(s);
                nextCondition.signal();
                state = expectNextState;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

