package com.tsu.zqy.aliTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Test3
 * @Author Elv1s
 * @Date 2019/7/3 15:53
 * @Description: 3. 三个线程交替打印alialiali...，一个打印a，一个打印l，一个打印i
 */
public class Test3 {
    public static void main(String[] args) {
        PrintALi printABC = new PrintALi();
        //开启线程
        new Thread(()->printABC.printA()).start();
        new Thread(()->printABC.printL()).start();
        new Thread(()->printABC.printI()).start();
    }
}

class PrintALi {
    private final Lock lock = new ReentrantLock();
    private Condition lockA = lock.newCondition();
    private Condition lockL = lock.newCondition();
    private Condition lockI = lock.newCondition();
    //标记
    int flag = 0;

    /**
     * 打印a
     */
    public void printA() {
        //锁
        lock.lock();
        try {
            while (true) {
                //flag == 0 打印 A
                while (flag != 0){
                    lockA.await();
                }
                System.out.print("a");
                //标记置为1  提示线程2 打印L
                flag = 1;
                lockL.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //解锁,  避免死循环
            lock.unlock();
        }
    }

    /**
     * 打印l
     */
    public void printL() {
        lock.lock();
        try {
            while (true) {
                //不等于1时不打印
                while (flag != 1){
                    lockL.await();
                }
                System.out.print("l");
                //提醒打印I线程开始答应
                flag = 2;
                lockI.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    /**
     * 打印i
     */
    public void printI() {
        lock.lock();
        try {
            while (true) {
                while (flag != 2){
                    lockI.await();
                }
                System.out.print("i");
                //开始重新打印A
                flag = 0;
                lockA.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
