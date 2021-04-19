package com.tsu.zqy.flow.command.action;

import com.alibaba.fastjson.JSONObject;
import com.tsu.zqy.flow.Context;
import com.tsu.zqy.flow.Node;
import lombok.Data;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
//@Slf4j
public class PrintHelloWorldCommand extends ActionCommand{

    @Override
    public void doExecute(Context context) {
        Node node = context.getNode();
        CommandAgrs commandAgrs = JSONObject.parseObject(node.getCommandArgs(), CommandAgrs.class);
        log("接收到的输出内容为: \t{0}", commandAgrs.printMessage);
    }

    @Data
    static class CommandAgrs {
        private String printMessage;
    }
}
