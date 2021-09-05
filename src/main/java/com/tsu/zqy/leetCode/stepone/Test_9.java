package com.tsu.zqy.leetCode.stepone;

import java.util.Stack;

/**
 * @ClassName Test_9
 * @Author Elv1s
 * @Date 2021/9/5 12:13
 * @Description:
 */
public class Test_9 {
    public static void main(String[] args){
        new Test_9().isPalindrome(1221);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int xt = x;
        while (xt != 0) {
            int temp  =  xt % 10;
            stack.add(temp);
            xt /= 10;
        }

        while (x != 0) {
            int temp  =  x % 10;
            if (!(stack.pop() == temp)) {
                return false;
            }
            x /= 10;
        }

        return true;
    }

}
