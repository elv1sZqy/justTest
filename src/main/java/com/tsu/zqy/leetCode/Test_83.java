package com.tsu.zqy.leetCode;

import jdk.nashorn.internal.ir.LiteralNode;

/**
 * @ClassName Test_83
 * @Author Elv1s
 * @Date 2019/7/22 13:56
 * @Description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_83 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(null);
        ListNode listNode1 = deleteDuplicates(listNode);

        while (listNode1.next != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }

    }


    public static ListNode deleteDuplicates(ListNode head) {
        // 为空的情况
        if (head == null || head.next == null){
            return head;
        }
        // 因为链表已经排序, 所以只要获得当前的值, 和下一个值进行比较即可, 如果相同, 则将指针指向下一位,以此类推
        ListNode currentNode = head;

        // 遍历
        while (currentNode.next != null){
            ListNode tempNode = currentNode.next;
            while (currentNode.val == tempNode.val){
                if (tempNode.next != null){
                    tempNode = tempNode.next;
                }
                else {
                    currentNode.next = null;
                    tempNode = null;
                    return head;
                }
            }
            // 将指针指向值不相同的节点
            currentNode.next = tempNode;
            // 指针向后移
            currentNode = tempNode;
        }

        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void setNext(ListNode next){
        this.next = next;
    }
}

