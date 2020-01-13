package com.tsu.zqy.leetCode.recursion;

import com.tsu.zqy.leetCode.wrapper.ListNode;
import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;

/**
 * @author zhuQiYun
 * @create 2020/1/13
 * @description :给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Test2 {

    public static void main(String[] args) {
        ListNode listNode = ListNodeWrapper.stringToListNode("[1]");
        ListNode listNode1 = new Test2().swapPairs(listNode);
        return;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        if (next == null) {
            return head;
        }
        ListNode nextNext = swapPairs(next.next);
        next.next = head;
        head.next = nextNext;
        return next;
    }


}
