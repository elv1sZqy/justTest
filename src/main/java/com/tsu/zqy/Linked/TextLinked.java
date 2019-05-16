package com.tsu.zqy.Linked;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TextLinked
 * @Author Elv1s
 * @Date 2019/5/2 12:28
 * @Description:
 */
public class TextLinked {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Node node = makeLinked(list);
        printlnNode(node);
        System.out.println("");

        Node head = makeLinked2(node);
        printlnNode(head);
    }

    /**
     * 正序:1->2->3->4->null
     * 倒叙:4->3->2->1->null
     * 颠倒linked
     * @param node
     * @return  倒叙后的head
     */
    private static Node makeLinked2(Node node) {
        if (node == null){
            return null;
        }
        if (node.getNext() == null){
            return node;
        }
        //将正序时当前节点的next指向当前节点.形成倒叙
        Node newHead = makeLinked2(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);

        return newHead;
    }

    /**
     * 正序的linked
     *  1->2->3->4->null
     * @param list
     * @return
     */
    private static Node makeLinked(List<Integer> list) {
        //为空直接返回null
        if (list.size() == 0 || list.isEmpty()){
            return  null;
        }

        //第一个1   第二个 2
        Node firstNode = new Node(list.get(0));
        //1->2
        firstNode.setNext(makeLinked(list.subList(1, list.size())));
        return firstNode;
    }


    /**
     * 打印linked
     * @param head
     */
    public static void printlnNode(Node head){
        if (head.getNext() != null){
            System.out.print(head.getValue()+"->");
            printlnNode(head.getNext());
        }
        else{
            System.out.print(head.getValue() + "->null");
            return;
        }
    }
}
