package com.tsu.zqy.flow;

import com.tsu.zqy.flow.command.Command;
import com.tsu.zqy.flow.command.action.ActionCommand;
import com.tsu.zqy.flow.command.gateway.GatewayCommand;
import com.tsu.zqy.flow.command.merge.MergeChainCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
public class WorkFlowGenerator {

    private static Map<String, Chain> chainMap = new HashMap<>();


    public static Node generateChain(List<Node> nodes, String rootTrack) {
        Node startNode = generate(nodes, rootTrack);
        injectMergeNodes(nodes);
        return startNode;
    }

    private static void injectMergeNodes(List<Node> collect) {
        List<Node> mergeNodes = collect.stream().filter(node -> {
            Integer nodeType = node.getNodeType();
            Command command = getCommandInstance(nodeType);
            boolean isMergeNode = command instanceof MergeChainCommand;
            return isMergeNode;
        }).collect(Collectors.toList());

        for (Node mergeNode : mergeNodes) {
            Command command = getCommandInstance(mergeNode.getNodeType());
            mergeNode.setCommandExecutor(command);
            if (command instanceof MergeChainCommand) {
                List<String> relationTrack = mergeNode.getRelationChain();
                for (String chainId : relationTrack) {
                    Chain relationChain = chainMap.get(chainId);
                    relationChain.getTailNode().setNextNode(mergeNode);
                }
                generate(collect, mergeNode.getUid());
            }
        }
    }

    public static Node generate(List<Node> nodes, String rootTrack) {
        Map<String, List<Node>> collect = nodes.stream().collect(Collectors.groupingBy(Node::getUid));
        List<Node> rootNodes = collect.get(rootTrack);
        Chain chain = new Chain();
        chainMap.put(rootTrack, chain);
        chain.setChainId(rootTrack);
        for (int i = 0; i < rootNodes.size(); i++) {
            Node currentNode = rootNodes.get(i);
            if (i == 0) {
                chain.setHeadNode(currentNode);
            }
            if (i == rootNodes.size() - 1) {
                chain.setTailNode(currentNode);
            }
            Integer nodeType = currentNode.getNodeType();
            Command command = getCommandInstance(nodeType);
            currentNode.setCommandExecutor(command);
            currentNode.setChain(chain);
            if (command instanceof ActionCommand) {
                setNextNode(rootNodes, i, currentNode);
            } else if (command instanceof MergeChainCommand) {
                List<String> relationTrack = currentNode.getRelationChain();
                for (String chainId : relationTrack) {
                    Chain relationChain = chainMap.get(chainId);
                    relationChain.getTailNode().setNextNode(currentNode);
                }
                setNextNode(rootNodes, i, currentNode);
            } else if (command instanceof GatewayCommand) {
                List<String> relationTrack = currentNode.getRelationChain();
                Map<String, Node> relationNodes = new HashMap<>(relationTrack.size());
                for (String track : relationTrack) {
                    Node generate = generate(nodes, track);
                    relationNodes.put(track, generate);
                }
                currentNode.setRelationNodes(relationNodes);
            }
        }
        return chain.getHeadNode();
    }

    private static void setNextNode(List<Node> rootNodes, int i, Node currentNode) {
        int nextIndex = i + 1;
        if (nextIndex < rootNodes.size()) {
            currentNode.setNextNode(rootNodes.get(nextIndex));
        }
    }

    private static Command getCommandInstance(Integer nodeType) {
        return CommandTypeEnum.getByType(nodeType).getCommandClass();
    }
}
