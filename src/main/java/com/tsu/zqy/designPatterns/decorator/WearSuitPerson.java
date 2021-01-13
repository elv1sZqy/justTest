package com.tsu.zqy.designPatterns.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @author zhuQiYun
 * @create 2021/1/13
 * @description :
 */
public class WearSuitPerson extends Decorator{

    WearSuitPerson(IPerson iPerson) {
        super(iPerson);
    }

    @Override
    public void getClothes() {
        System.out.println("穿西装");
        super.getClothes();
    }
}
