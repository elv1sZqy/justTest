package com.tsu.zqy.designPatterns.decorator;

/**
 * @author zhuQiYun
 * @create 2021/1/13
 * @description :  装饰类，
 *
 * 以Java IO 中的输入流举例
 * 抽象构建： {@link java.io.InputStream}
 * 具体构建： {@link java.io.FileInputStream} , {@link java.io.ByteArrayInputStream}
 * 装饰角色: {@link java.io.FilterInputStream}
 * 具体装饰角色： {@link java.io.BufferedInputStream}
 */
public class Decorator extends IPerson {
    IPerson iPerson;

    Decorator(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    @Override
    public void getClothes() {
        iPerson.getClothes();
    }
}
