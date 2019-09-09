package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test_160
 * @Author zhuQiYun
 * @Date 2019/8/20 9:51
 * @Description: 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_160 {

    /**
     * 思路:  先将一条链表中的值放入map中, key是节点的值 , value 是节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>();
        // 将headA放入map
        while (headA != null) {
            map.put(headA.val, headA);
            headA = headA.next;
        }
        // 遍历对比
        while (headB != null){
            boolean isExsit = map.containsValue(headB);
            if (isExsit){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

}
