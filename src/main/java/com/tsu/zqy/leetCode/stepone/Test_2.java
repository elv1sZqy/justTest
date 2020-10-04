package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.ListNode;

/**
 * @ClassName Test_2
 * @Author Elv1s
 * @Date 2020/10/4 8:30
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Test_2 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode resultNode = new ListNode(0);
            ListNode node = resultNode;
            while (l1 != null || l2 != null || carry != 0) {
                int currentNodeSum = 0;
                if (l1 != null) {
                    currentNodeSum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    currentNodeSum += l2.val;
                    l2 = l2.next;
                }
                currentNodeSum += carry;
                carry = currentNodeSum / 10;
                ListNode nextNode = new ListNode(currentNodeSum % 10);
                node.next = nextNode;
                node = nextNode;
            }
            return resultNode.next;
        }
    }

    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean carry = false;
            ListNode resultNode = new ListNode(0);
            ListNode node = resultNode;
            while (true) {
                int val1 = 0;
                int val2 = 0;
                if (l1 == null && l2 == null) {
                    if (carry) {
                        node.next = new ListNode(1);
                    }
                    break;
                }
                if (null != l1) {
                    val1 = l1.val;
                    l1 = l1.next;
                }
                if (null != l2) {
                    val2 = l2.val;
                    l2 = l2.next;
                }
                // 节点两两相加, 相加大于10 就进位, 设置一个进位标识符
                int currentNodeSum = val1 + val2;
                if (carry) {
                    currentNodeSum += 1;
                    carry = false;
                }
                if (currentNodeSum > 9) {
                    carry = true;
                }
                // 如果其中一个节点大于另一个节点, 那么后续几位就是长的链表中的值
                ListNode nextNode = new ListNode(currentNodeSum % 10);
                node.next = nextNode;
                node = nextNode;
            }
            return resultNode.next;
        }
    }

    /*public static void main(String[] args){
        ListNode listNode = ListNodeWrapper.stringToListNode("[9,9,9,9,9,9,9]");
        ListNode listNode1 = ListNodeWrapper.stringToListNode("[9,9,9,9]");
        Solution solution = new Solution();
        solution.addTwoNumbers(listNode, listNode1);
    }*/

}
