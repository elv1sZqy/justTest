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
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Test_234 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeWrapper.stringToListNode("{1,1}");
        new Test_234().isPalindrome(listNode);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head !=null){
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 -i))){
                return false;
            }
        }
        return true;
    }
}
