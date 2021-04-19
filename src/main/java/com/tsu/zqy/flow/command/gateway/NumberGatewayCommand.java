package com.tsu.zqy.flow.command.gateway;

import com.alibaba.fastjson.JSONArray;
import com.tsu.zqy.flow.Context;
import com.tsu.zqy.flow.Node;
import com.tsu.zqy.flow.NodeExecuteThreadPool;
import lombok.Data;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
public class NumberGatewayCommand extends GatewayCommand {

    @Override
    public void doExecute(Context context) {
        Node node = context.getNode();
        Integer num = context.getNum();
        System.out.println("获取到的数字是: " + num);
        List<ConditionsDTO> conditionsDTOS = JSONArray.parseArray(node.getCommandArgs(), ConditionsDTO.class);

        for (int i = conditionsDTOS.size() - 1; i >= 0; i--) {
            ConditionsDTO conditionsDTO = conditionsDTOS.get(i);
            if (conditionsDTO.getBiggerThan() <= num) {
                String uid = conditionsDTO.getUid();
                Node nextNode = node.getRelationNodes().get(uid);
                Context currentContext = null;
                try {
                    currentContext = (Context) context.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                currentContext.setNode(nextNode);
                Context finalCurrentContext = currentContext;
                NodeExecuteThreadPool.pool.execute(() -> nextNode.getCommandExecutor().execute(finalCurrentContext));
//                return;
            }
        }
    }

    @Data
    public static class ConditionsDTO {
        /**
         * uid : 20
         * biggerThan : 10
         */
        private String uid;
        private Integer biggerThan;
    }
}
