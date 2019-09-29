package com.tsu.zqy.leetCode.steptwo;

import com.google.common.collect.Lists;
import com.tsu.zqy.leetCode.wrapper.ListNode;
import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;

import java.util.List;

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
        new Test_206().reverseList(listNode);
    }

    public ListNode reverseList(ListNode head) {
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
