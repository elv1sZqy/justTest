package com.tsu.zqy.designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/8/12
 * @description :
 */
public abstract class CarModel {
    private List<String> sequence  = new ArrayList<>();
    
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    
    final public void run() {
        for (String command : sequence) {
            if ("1".equals(command)) {
                start();
            } else if ("2".equals(command)) {
                alarm();
            } else if ("3".equals(command)) {
                stop();
            }
        }
    }

    final public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
