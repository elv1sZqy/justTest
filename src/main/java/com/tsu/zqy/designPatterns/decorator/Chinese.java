package com.tsu.zqy.designPatterns.decorator;

/**
 * @author zhuQiYun
 * @create 2021/1/13
 * @description :
 */
public class Chinese extends IPerson{

    @Override
    public void getClothes() {
        System.out.println("穿汉服");
    }
}
