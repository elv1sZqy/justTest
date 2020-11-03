package com.tsu.zqy.designPatterns.builder;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public abstract class CarBuilder {
    public abstract void setSequence(List<String> sequence);

    public abstract CarModel getCarModel();
}
