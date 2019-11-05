package com.tsu.zqy.leetCode.steptwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2019/10/17
 * @description :
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_232 {
        public static void main(String[] args) {
            Test_232 test_232 = new Test_232();
            test_232.push(1);
            test_232.push(2);
            test_232.push(3);
            test_232.push(1);
            int pop = test_232.pop();
        }

        private List<Integer> list;
        private Integer num;

        /** Initialize your data structure here. */
        public Test_232() {
            list = new ArrayList<>();
            num = 0;
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            list.add(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Integer integer = list.get(num);
            list.remove(integer);
            return integer;
        }

        /** Get the front element. */
        public int peek() {
            Integer integer = list.get(num);
            return integer;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return list.isEmpty();
        }
}
