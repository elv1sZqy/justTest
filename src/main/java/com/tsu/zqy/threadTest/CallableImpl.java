package com.tsu.zqy.threadTest;

import java.util.concurrent.Callable;

/**
 * @ClassName CallableImpl
 * @Author Elv1s
 * @Date 2019/6/19 12:08
 * @Description:
 */
public class CallableImpl implements Callable<Integer> {

    private int sum;
    private int start;
    private int end;

    public CallableImpl(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = start; i < end; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
            sum += i;
        }

        System.out.println(Thread.currentThread().getName() + "   完成任务");
        return sum;
    }
}
