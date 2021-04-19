package com.tsu.zqy.flow;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Scanner;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 * <p>
 * <p>
 * {
 * "activityName": "xxx",
 * "workflow": [
 * {
 * "uid": 10,
 * "nodeName": "yyy",
 * "nodeType": 1
 * },
 * {
 * "uid": 10,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"hello\"}"
 * },
 * {
 * "uid": 10,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"world\"}"
 * },
 * {
 * "uid": 10,
 * "nodeName": "er",
 * "nodeType": 3,
 * "commandArgs": "{\"maxNumber\":60}"
 * },
 * {
 * "uid": 10,
 * "nodeName": "er",
 * "nodeType": 4,
 * "relationTrack": [
 * 20,
 * 30,
 * 50
 * ],
 * "commandArgs": "[{\"uid\":20,\"biggerThan\":0},{\"uid\":30,\"biggerThan\":10},{\"uid\":50,\"biggerThan\":50}]"
 * },
 * {
 * "uid": 20,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"大于0\"}"
 * },
 * {
 * "uid": 20,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"后面一个节点\"}"
 * },
 * {
 * "uid": 20,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"后面第二个节点\"}"
 * },
 * {
 * "uid": 30,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"大于10\"}"
 * },
 * {
 * "uid": 50,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"大于50\"}"
 * },
 * {
 * "uid": 20,
 * "nodeName": "er",
 * "nodeType": 3,
 * "commandArgs": "{\"maxNumber\":60}"
 * },
 * {
 * "uid": 20,
 * "nodeName": "er",
 * "nodeType": 4,
 * "relationTrack": [
 * 60,
 * 70,
 * 80
 * ],
 * "commandArgs": "[{\"uid\":60,\"biggerThan\":0},{\"uid\":70,\"biggerThan\":10},{\"uid\":80,\"biggerThan\":50}]"
 * },
 * {
 * "uid": 60,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"大于0\"}"
 * },
 * {
 * "uid": 60,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"后面一个节点\"}"
 * },
 * {
 * "uid": 60,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"后面第二个节点\"}"
 * },
 * {
 * "uid": 70,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"大于10\"}"
 * },
 * {
 * "uid": 80,
 * "nodeName": "er",
 * "nodeType": 2,
 * "commandArgs": "{\"printMessage\":\"大于50\"}"
 * }
 * ]
 * }
 */
public class Test {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            String next = input.next();
            ActivityDefine activityDefine =
                    JSONObject.parseObject(next, ActivityDefine.class);
            List<Node> workflow = activityDefine.getWorkflow();
            Node startNode = WorkFlowGenerator.generateChain(workflow, "10");
            Context context = new Context();
            context.setActivityName("测试");
            context.setNode(startNode);
            startNode.getCommandExecutor().execute(context);
        }

    }
}
