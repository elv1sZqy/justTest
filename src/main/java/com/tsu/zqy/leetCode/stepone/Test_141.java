package com.tsu.zqy.leetCode.stepone;


import com.tsu.zqy.leetCode.wrapper.ListNodeWrapper;
import com.tsu.zqy.leetCode.wrapper.ListNode;

import java.util.*;


/**
 * @ClassName Test_141
 * @Author zhuQiYun
 * @Date 2019/8/19 11:26
 * @Description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_141 {
    public static void main(String[] args){
        ListNode listNode = ListNodeWrapper.stringToListNode("[1,2]");

        System.out.println(new Test_141().hasCycle(listNode));
    }

    /**
     * 思路  : 一种超级强的想法!!!!!
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        int flag = 19971130;
        while (head != null){
            if (head.val == flag){
                return true;
            }
            else {
                head.val = flag;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        Set<ListNode>set=new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == head){
            return true;
        }
        //快指针
        ListNode q = head;
        while(q != null){
            if(q.next == null){
                return false;
            }
            //慢指针
            head = head.next;
            q = q.next.next;
            //相遇即有环
            if(head == q){
                return true;
            }
        }
        return false;
    }

}
