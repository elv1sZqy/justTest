package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.ListNode;

import java.util.ArrayList;

public class Test_21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode n = solution(l1,l2);
    }

    private static ListNode solution(ListNode l1, ListNode l2) {

    /*    if (l1 == null && l2 != null){
            return l2;
        }
        else if(l2 == null && l1 != null){
            return l1;
        }
*/
        ArrayList<Integer> list = new ArrayList<>();
        ListNode currentNode = l1;
        while (currentNode != null){
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        currentNode = l2;
        while (currentNode != null){
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        if (list.size() == 0){
            return null;
        }

        list.sort((x,y)->x.compareTo(y));

        ListNode listNode = new ListNode(list.get(0));
        currentNode = listNode;

        for (int i = 1; i < list.size(); i++) {
            ListNode listNode1 = new ListNode(list.get(i));
            setNext(currentNode, listNode1);
            currentNode = listNode1;
        }


        return listNode;
    }

    private static ListNode setNext(ListNode currentNode, ListNode listNode1) {
        currentNode.next = listNode1;
        currentNode = currentNode.next;
        return currentNode;
    }

}
