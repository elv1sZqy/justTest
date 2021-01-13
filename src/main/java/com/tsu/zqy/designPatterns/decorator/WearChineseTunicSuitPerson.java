package com.tsu.zqy.designPatterns.decorator;

/**
 * @author zhuQiYun
 * @create 2021/1/13
 * @description :
 */
public class WearChineseTunicSuitPerson extends Decorator{
    WearChineseTunicSuitPerson(IPerson iPerson) {
        super(iPerson);
    }

    @Override
    public void getClothes() {
        System.out.println("穿中山装");
        super.getClothes();
    }
}
