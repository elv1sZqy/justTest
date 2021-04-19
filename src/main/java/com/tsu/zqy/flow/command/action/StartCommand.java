package com.tsu.zqy.flow.command.action;

import com.tsu.zqy.flow.Context;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
//@Slf4j
public class StartCommand extends ActionCommand {

    @Override
    public void doExecute(Context context) {
        System.out.println("开始节点...");

    }
}
