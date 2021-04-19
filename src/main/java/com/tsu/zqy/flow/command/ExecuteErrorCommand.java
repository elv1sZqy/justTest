package com.tsu.zqy.flow.command;

import com.tsu.zqy.flow.Context;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
public interface ExecuteErrorCommand extends Command {
    /**
     * 抛异常时执行的逻辑
     * @param context
     */
    void executeWhenHappenedError(Context context);
}
