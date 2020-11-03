package com.tsu.zqy.designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public class Client {
    public static void main(String[] args) {
        List<String> sequence = new ArrayList<>();
        sequence.add("1");
        sequence.add("2");
        sequence.add("2");
        sequence.add("3");
        sequence.add("1");
        sequence.add("3");
        CarBuilder bmwCarBuilder = new BMWCarBuilder();
        bmwCarBuilder.setSequence(sequence);
        CarModel carModel = bmwCarBuilder.getCarModel();
        carModel.run();
        CarBuilder benzCarBuilder = new BenzCarBuilder();
        benzCarBuilder.setSequence(sequence);
        benzCarBuilder.getCarModel().run();

    }
}
