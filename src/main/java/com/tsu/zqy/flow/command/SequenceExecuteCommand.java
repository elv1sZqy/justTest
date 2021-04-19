package com.tsu.zqy.flow.command;

import com.tsu.zqy.flow.Context;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
public interface SequenceExecuteCommand extends Command {
    /**
     * 顺序执行
     * @param context
     */
    void sequenceExecute(Context context);
}
