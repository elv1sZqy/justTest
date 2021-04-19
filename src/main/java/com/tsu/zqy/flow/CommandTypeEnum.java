package com.tsu.zqy.flow;

import com.tsu.zqy.flow.command.*;
import com.tsu.zqy.flow.command.action.PrintHelloWorldCommand;
import com.tsu.zqy.flow.command.action.RandomNumCommand;
import com.tsu.zqy.flow.command.action.StartCommand;
import com.tsu.zqy.flow.command.gateway.NumberGatewayCommand;
import com.tsu.zqy.flow.command.merge.AsyncMergeChainCommand;
import com.tsu.zqy.flow.command.merge.SyncMergeChainCommand;

import java.util.Arrays;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description : 命令节点的类型枚举类
 */
public enum CommandTypeEnum {
    START_COMMAND(1, new StartCommand()),
    PRINT_COMMAND(2, new PrintHelloWorldCommand()),
    RANDOM_COMMAND(3, new RandomNumCommand()),
    NUMBER_GATEWAY_COMMAND(4, new NumberGatewayCommand()),
    SYNC_MERGE_COMMAND(5, new SyncMergeChainCommand()),
    ASYNC_MERGE_COMMAND(6, new AsyncMergeChainCommand());

    private Integer type;
    private Command command;

    CommandTypeEnum(final Integer type, Command command) {
        this.type = type;
        this.command = command;
    }

    public Integer getType() {
        return this.type;
    }

    public Command getCommandClass() {
        return this.command;
    }

    public static CommandTypeEnum getByType(Integer type) {
        CommandTypeEnum command =
                Arrays.stream(CommandTypeEnum.values()).filter(commandTypeEnum -> commandTypeEnum.type.equals(type)).findFirst().get();
        return command;
    }
}
