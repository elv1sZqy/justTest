package com.tsu.zqy.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuQiYun
 * @create 2021/2/4
 * @description :
 */
public class RingBufferWheelTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        RingBufferWheel ringBufferWheel = new RingBufferWheel(executorService,20);

        for (int i = 0; i < 22; i++) {
            RingBufferWheel.Task task = new RingBufferWheel.Task();
            task.setKey(i);
            ringBufferWheel.addTask(task);
        }

        new Thread(() -> ringBufferWheel.start(), "ringBufferTask").start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ringBufferWheel.stop(false);
    }
}
