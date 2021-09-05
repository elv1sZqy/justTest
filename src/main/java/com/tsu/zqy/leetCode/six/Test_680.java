package com.tsu.zqy.leetCode.six;

import java.util.Stack;

/**
 * @ClassName Test_680
 * @Author Elv1s
 * @Date 2021/9/4 16:20
 * @Description:
 */
public class Test_680 {
    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(new Test_680().validPalindrome(s));
    }


    public boolean validPalindrome(String s) {



        int chance = s.length() % 2 == 0 ? 2 : 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            Character pop = stack.pop();
            char c = s.charAt(i);
            if (!pop.equals(c)) {
                if (chance == 0) {
                    return false;
                }
                chance--;
            }
        }
        return true;
    }

}
