package com.tsu.zqy.flow.command.merge;


import com.tsu.zqy.flow.Context;
import com.tsu.zqy.flow.command.AbstractCommand;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
public abstract class MergeChainCommand extends AbstractCommand {
    @Override
    public abstract void doExecute(Context context);
}

