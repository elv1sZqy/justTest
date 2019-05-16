package com.tsu.zqy.threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName RunnableImpl
 * @Author Elv1s
 * @Date 2019/4/17 7:39
 * @Description:
 */
public class RunnableImpl implements Runnable {
    int a = 0;
    Object o = null;

    RunnableImpl(int a,Object o) {
        this.a = a;
        this.o = o;
    }

    RunnableImpl() {
    }
   Lock lock =  new ReentrantLock();

    public void run() {
        while (true) {
            synchronized (o) {
            //lock.lock();
            if (a > 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("a减少了1" + "  --" + Thread.currentThread().getName());
                    a--;
                    System.out.println("现在a= " + a);
                    //自己进入等待
                    if (a == 0){
                        System.out.println("我要睡了");
                        o.wait();
                        System.out.println("我又醒了");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //lock.unlock();
            }
        }

    }

    //public synchronized void func(){
    //    if (a > 0) {
    //        try {
    //            Thread.sleep(1000);
    //            System.out.println("a减少了1" + "  --" + Thread.currentThread().getName());
    //            a--;
    //            System.out.println("现在a= " + a);
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    }
    //}
}
