package com.tsu.zqy.leetCode.steptwo;

import com.tsu.zqy.leetCode.wrapper.ListNode;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2019/9/21
 * @description :删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->1->1->1->5->6->1, val = 1
 * 输出: 1->2->3->4->5
 */
public class Test_203 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
       /* ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;*/
        new Test_203().removeElements(listNode, 1);
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        while (head.val == val){
            head = head.next;
            if (head == null){
                return null;
            }
        }
        ListNode currentNode = head;
        while (currentNode != null){
            ListNode next = currentNode.next;
            while (next!= null && next.val == val){
                next = next.next;
                if (next == null){
                    currentNode.next = null;
                    return head;
                }
            }
            currentNode.next = next;
            currentNode = next;
        }
        return head;
    }
}
