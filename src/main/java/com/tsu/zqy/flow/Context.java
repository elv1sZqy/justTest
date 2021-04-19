package com.tsu.zqy.flow;

import lombok.Data;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
@Data

public class Context implements Cloneable{
    private String activityName;

    private Integer activityId;

    private Integer num;

    private Node node;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
