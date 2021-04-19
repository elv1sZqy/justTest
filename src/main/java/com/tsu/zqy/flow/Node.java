package com.tsu.zqy.flow;

import com.tsu.zqy.flow.command.Command;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
@Data
@ToString(exclude = "chain")
public class Node {

    /**
     * 链路id
     */
    private String uid;

    private String nodeName;

    private Integer nodeType;

    /**
     * 下一个执行节点
     */
    private Node nextNode;

    /**
     * 当前节点属于的链路
     */
    private Chain chain;

    private Command commandExecutor;

    private String commandArgs;

    /**
     * 存在关联的节点id
     */
    private Map<String, Node> relationNodes;

    /**
     * 存在关联的链路id
     */
    private List<String> relationChain;
}
