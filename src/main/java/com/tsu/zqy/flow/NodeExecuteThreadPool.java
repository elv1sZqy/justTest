package com.tsu.zqy.flow;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
public class NodeExecuteThreadPool {

    public static ThreadPoolExecutor pool = null;

    static {
        pool = new ThreadPoolExecutor(2, 4, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024));
    }

}
