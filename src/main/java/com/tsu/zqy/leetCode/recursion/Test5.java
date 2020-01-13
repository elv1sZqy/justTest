package com.tsu.zqy.leetCode.recursion;

import com.tsu.zqy.leetCode.wrapper.ListNode;
import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;
import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2020/1/13
 * @description :反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Test5 {

    @Test
    public void fun(){
        ListNode listNode = ListNodeWrapper.stringToListNode("[1,2,3,4,5]");
        ListNode listNode1 = new Test5().reverseList(listNode);
        return;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = reverseList(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
