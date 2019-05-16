package com.tsu.zqy.Linked;

/**
 * @ClassName Node
 * @Author Elv1s
 * @Date 2019/5/2 12:25
 * @Description:
 */
public class Node {

    private final int value;
    private Node next;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = null;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
