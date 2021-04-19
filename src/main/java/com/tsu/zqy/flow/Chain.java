package com.tsu.zqy.flow;

import lombok.Data;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
@Data
public class Chain {

    private String chainId;

    private Node headNode;

    private Node tailNode;
}
