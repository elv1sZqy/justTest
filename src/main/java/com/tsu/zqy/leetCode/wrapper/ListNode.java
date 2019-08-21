package com.tsu.zqy.leetCode.wrapper;

import lombok.Data;

/**
 * @ClassName ListNode
 * @Author zhuQiYun
 * @Date 2019/8/19 11:24
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}