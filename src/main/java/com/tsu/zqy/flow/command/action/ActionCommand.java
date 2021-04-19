package com.tsu.zqy.flow.command.action;

import com.tsu.zqy.flow.Context;
import com.tsu.zqy.flow.command.AbstractCommand;
import com.tsu.zqy.flow.command.ExecuteErrorCommand;
import com.tsu.zqy.flow.command.SequenceExecuteCommand;

import java.text.MessageFormat;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
public abstract class ActionCommand extends AbstractCommand {

    public void log(String message, Object... args) {
        System.out.println("\t" + Thread.currentThread().getName() + "\t" + MessageFormat.format(message, args));
    }

    @Override
    public abstract void doExecute(Context context);

}
