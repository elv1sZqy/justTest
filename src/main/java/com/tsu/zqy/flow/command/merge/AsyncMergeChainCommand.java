package com.tsu.zqy.flow.command.merge;

import com.tsu.zqy.flow.Context;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
public class AsyncMergeChainCommand extends MergeChainCommand {

    @Override
    public void doExecute(Context context) {
        System.out.println("\t" + Thread.currentThread().getName() + "\t" + "进入不等待的分支合并节点");
        System.out.println("\t" + Thread.currentThread().getName() + "\t" + context.getNum());
    }
}
