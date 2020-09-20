package com.tsu.zqy.HashMap;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName UnsafeTest
 * @Author Elv1s
 * @Date 2020/2/1 17:02
 * @Description:
 */
public class UnsafeTest {

    private int age;

    private static Unsafe unsafe;
    private static Long OFFSET;


    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe  = (Unsafe) theUnsafe.get(null);
            OFFSET = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("age"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        final UnsafeTest unsafeTest = new UnsafeTest();
        new Thread(() -> {
          while (true) {
              boolean b = unsafe.compareAndSwapInt(unsafeTest, OFFSET, unsafeTest.age, unsafeTest.age+1);
              if (b) {
                  System.out.println(unsafeTest.age);
              }
              try {
                  Thread.sleep(500);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }).start();


        new Thread(() -> {
            while (true) {
                boolean b = unsafe.compareAndSwapInt(unsafeTest, OFFSET, unsafeTest.age, unsafeTest.age+1);
                if (b) {
                    System.out.println(unsafeTest.age);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
