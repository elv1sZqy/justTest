package com.tsu.zqy.leetCode.steptwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2019/9/30
 * @description :使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {

    private static List myStack;
    private Integer lastOne = -1;
    /** Initialize your data structure here. */
    public MyStack() {
        myStack = new ArrayList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        myStack.add(x);
        lastOne++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        return 1;
    }

    /** Get the top element. */
    public int top() {
        return 1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return false;
    }
}
