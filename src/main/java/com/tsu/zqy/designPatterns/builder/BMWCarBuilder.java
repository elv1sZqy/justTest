package com.tsu.zqy.designPatterns.builder;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public class BMWCarBuilder extends CarBuilder {
    BMWCarModel bmwCarModel = new BMWCarModel();
    @Override
    public void setSequence(List<String> sequence) {
        bmwCarModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return bmwCarModel;
    }
}
