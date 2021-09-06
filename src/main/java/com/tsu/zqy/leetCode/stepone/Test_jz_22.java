package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.ListNode;
import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;

import java.util.Stack;

/**
 * @author zhuQiYun
 * @create 2021/9/2
 * @description :
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class Test_jz_22 {

    public static void main(String[] args) {
        ListNode listNode = ListNodeWrapper.stringToListNode("(1)");
        ListNodeWrapper.prettyPrintLinkedList(new Test_jz_22().getKthFromEnd(listNode, 1));
    }

    private ListNode getKthFromEnd(ListNode listNode, int k) {
        ListNode tempNode = listNode;
        for (int i = 0; i < k; i++) {
            listNode = listNode.next;
        }
        while (listNode != null) {
            listNode = listNode.next;
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        int count = 0;
        ListNode result = null;
        ListNode temp = head;
        while (head != null) {
            head = head.next;
            count++;
        }
        if (k <= count) {
            for (int i = count; i >= 0; i--) {
                if (i - k == 0) {
                    result = temp;
                    break;
                }
                temp = temp.next;

            }

        }
        return result;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        int count = 0;
        ListNode result = null;
        Stack<ListNode> stack = new Stack();
        while (head != null) {
            stack.add(head);
            head = head.next;
            count++;
        }
        if (k <= count) {
            for (int i = 0; i < k; i++) {
                result = stack.pop();
            }
        }
        return result;
    }
}
