package com.tsu.zqy.designPatterns.builder;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public class BenzCarModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("奔驰开始跑");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰停止");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰鸣笛");
    }
}
