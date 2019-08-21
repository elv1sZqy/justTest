package com.tsu.zqy.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test_155
 * @Author zhuQiYun
 * @Date 2019/8/19 20:18
 * @Description: 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_155 {

    public static void main(String[] args) {
        Test_155 demo = new Test_155();
        demo.push(1);
        demo.push(2);
        System.out.println(demo.top());
        System.out.println(demo.getMin());
        demo.pop();
        System.out.println(demo.getMin());
        System.out.println(demo.top());


    }

    private int min = Integer.MAX_VALUE;
    private List<Integer> list;
    private int top = -1;

    public Test_155() {
        list = new ArrayList();
    }

    public void push(int x) {
        min = min < x ? min : x;
        list.add(x);
        top++;
    }

    public void pop() {
        if (list != null && list.get(top) != null) {
            list.remove(top);
            // 当移除的top是最小值时,就要再找最小值
            int temp = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                temp = list.get(i) < temp ? list.get(i) : temp;
            }
            min = temp;
            top--;
        }
    }

    public int top() {
        return list.get(top);
    }

    public int getMin() {
        return min;
    }

}
