package com.tsu.zqy.leetCode.steptwo;

import com.tsu.zqy.leetCode.wrapper.ListNode;
import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2019/10/17
 * @description :
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Test_234 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeWrapper.stringToListNode("{1,2,3,4,2,1}");
        System.out.println(new Test_234().isPalindrome(listNode));
    }

    private ListNode tempNode;

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        tempNode = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head.next == null) {
            return head.val == tempNode.val;
        }
        boolean dfs = dfs(head.next);
        tempNode = tempNode.next;
        boolean b = tempNode.val == head.val;
        return b & dfs;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
