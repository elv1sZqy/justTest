package com.tsu.zqy.threadTest;

/**
 * @ClassName Thread
 * @Author Elv1s
 * @Date 2019/4/17 7:39
 * @Description:
 */
public class ThreadTest {

   public static void main(String[] args){
       final int  a = 10;
       final Object o = new Object();
       Runnable runnable = new RunnableImpl(a,0);
       Thread t1  = new Thread(runnable);
       Thread t2 = new Thread(runnable);

       t1.start();
       //t2.start();
       //ThreadDemo threadDemo = new ThreadDemo();

       new Thread(){
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName() + "是匿名内部类方式");
               while (true){
                   System.out.println(a);
                   if (a == 0 ){
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("把你叫醒");
                       o.notify();
                   }
               }

           }
       }.start();

        //threadDemo.start();

   }

}
