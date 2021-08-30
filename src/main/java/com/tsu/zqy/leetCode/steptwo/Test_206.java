package com.tsu.zqy.leetCode.steptwo;

import com.google.common.collect.Lists;
import com.tsu.zqy.leetCode.wrapper.ListNode;
import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhuQiYun
 * @create 2019/9/29
 * @description :
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Test_206 {

    public static void main(String[] args) {
        String l = "(1,2,3,4,6)";
        ListNode listNode = ListNodeWrapper.stringToListNode(l);
        ListNode listNode1 = new Test_206().reverseList(listNode);
        ListNodeWrapper.prettyPrintLinkedList(listNode1);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        while (nextNode != null) {
            ListNode next = nextNode.next;
            nextNode.next = head;
            if (next == null) {
                return nextNode;
            }
            head = nextNode;
            nextNode = next;
        }
        return head;
    }

    private ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Queue<ListNode> queue = new LinkedList<>();
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        head = queue.remove();
        head.next = null;
        while (!queue.isEmpty()) {
            ListNode remove = queue.remove();
            remove.next = head;
            head = remove;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        List<ListNode> list = Lists.newArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        head = list.get(list.size() - 1);
        ListNode currentNode = head;
        for (int i = list.size() - 2; i >= 0; i--) {
            currentNode.next = list.get(i);
            currentNode = currentNode.next;
            if (i == 0) {
                currentNode.next = null;
            }
        }

        return head;
    }
}
