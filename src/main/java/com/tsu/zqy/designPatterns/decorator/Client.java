package com.tsu.zqy.designPatterns.decorator;

/**
 * @author zhuQiYun
 * @create 2021/1/13
 * @description :
 */
public class Client {
    public static void main(String[] args) {
        IPerson person = new Chinese();
        person = new WearChineseTunicSuitPerson(person);
        person = new WearSuitPerson(person);
        person.getClothes();
    }
}
