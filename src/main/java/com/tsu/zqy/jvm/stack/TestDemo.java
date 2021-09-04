package com.tsu.zqy.jvm.stack;

/**
 * @author zhuQiYun
 * @create 2021/8/16
 * @description :
 */
public class TestDemo {
    private int test(String s) {
        {
            int b = 2;
        }
        return 1;
    }
}
