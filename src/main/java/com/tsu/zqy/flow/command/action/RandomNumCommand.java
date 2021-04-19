package com.tsu.zqy.flow.command.action;

import com.alibaba.fastjson.JSONObject;
import com.tsu.zqy.flow.Context;
import lombok.Data;

import java.util.Random;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
public class RandomNumCommand extends ActionCommand {
    @Override
    public void doExecute(Context context) {
        RandomNumCommand.CommandAgrs commandAgrs = JSONObject.parseObject(context.getNode().getCommandArgs(), RandomNumCommand.CommandAgrs.class);

        Random random = new Random();
        int num = random.nextInt(commandAgrs.maxNumber);
        log("生成的随机数字{0}", num);
        context.setNum(num);
    }

    @Data
    static class CommandAgrs {
        private Integer maxNumber;
    }
}
