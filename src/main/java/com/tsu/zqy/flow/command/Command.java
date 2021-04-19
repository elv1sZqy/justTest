package com.tsu.zqy.flow.command;


import com.tsu.zqy.flow.Context;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
public interface Command {
    void execute(Context context);
}
