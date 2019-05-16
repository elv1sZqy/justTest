package com.tsu.zqy.threadTest;

/**
 * @ClassName ThreadDemo
 * @Author Elv1s
 * @Date 2019/4/17 7:56
 * @Description:
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"是继承方式");
    }
}
