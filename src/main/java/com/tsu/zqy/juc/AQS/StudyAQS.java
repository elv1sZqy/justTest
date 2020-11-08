package com.tsu.zqy.juc.AQS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName StudyAQS
 * @Author Elv1s
 * @Date 2020/10/24 9:03
 * @Description:
 */
public class StudyAQS {

    private static Lock lock = new ReentrantLock();
    public static void main(String[] args){
        lock.lock();
        System.out.println("do some thing..");
        lock.unlock();
    }

}
