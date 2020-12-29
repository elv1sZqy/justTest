package com.tsu.zqy.proxy.dynamic.impl;

import com.tsu.zqy.proxy.dynamic.Say;

/**
 * @author zhuQiYun
 * @create 2020/11/16
 * @description :
 */
public class SayHi implements Say {
    private String name;

    public SayHi(final String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println( name + "say hi");
    }

    @Override
    public String callBack(String name) {
        System.out.println(name + "  hello");
        return name + "11";
    }
}
