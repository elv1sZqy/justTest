package com.tsu.zqy.designPatterns.builder;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public class BenzCarBuilder extends CarBuilder {
    BenzCarModel benzCarModel = new BenzCarModel();
    @Override
    public void setSequence(List<String> sequence) {
        benzCarModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benzCarModel;
    }
}
