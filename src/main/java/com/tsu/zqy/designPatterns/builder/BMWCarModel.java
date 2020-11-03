package com.tsu.zqy.designPatterns.builder;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public class BMWCarModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("宝马开始跑");
    }

    @Override
    protected void stop() {
        System.out.println("宝马停止");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣笛");
    }
}
