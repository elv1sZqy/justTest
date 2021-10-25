package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhuQiYun
 * @create 2021/10/21
 * @description :
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_jz_6 {

    /**
     * 用栈
     *
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        int[] nums = null;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        nums = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            nums[index++] = stack.pop();
        }
        return nums;
    }

}
