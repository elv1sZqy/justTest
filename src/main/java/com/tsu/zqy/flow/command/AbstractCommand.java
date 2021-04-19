package com.tsu.zqy.flow.command;

import com.tsu.zqy.flow.Context;
import com.tsu.zqy.flow.Node;

/**
 * @author zhuQiYun
 * @create 2021/4/19
 * @description :
 */
public abstract class AbstractCommand implements Command, ExecuteErrorCommand, SequenceExecuteCommand {

    public void before(Context context) {
        // 交给子类自己去实现
    }

    @Override
    public void execute(Context context) {
        try {
            before(context);
            doExecute(context);
            after(context);
        } catch (Exception e) {
            executeWhenHappenedError(context);
        }
    }

    public void after(Context context) {
        // 默认是顺序执行, 如果不需要顺序执行, 就重载一下
        sequenceExecute(context);
    }


    /**
     * 实际干事情的方法
     * @param context
     */
    public abstract void doExecute(Context context);

    @Override
    public void executeWhenHappenedError(Context context) {
        System.out.println("发生了异常");
    }

    @Override
    public void sequenceExecute(Context context) {
        Node nextNode = context.getNode().getNextNode();
        if (nextNode != null && nextNode.getCommandExecutor() != null) {
            context.setNode(nextNode);
            nextNode.getCommandExecutor().execute(context);
        }
    }
}
