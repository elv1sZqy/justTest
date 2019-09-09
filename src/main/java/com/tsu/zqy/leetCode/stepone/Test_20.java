package com.tsu.zqy.leetCode.stepone;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test_20 {
    public static void main(String[] args) {
        String s =  "{[]}";
        boolean isTrue = isValid(s);
        System.out.println(isTrue);
    }

    private static boolean isValid(String s) {
        if (s == ""){
            return false;
        }

        Map<String,String> map = new HashMap<>();
        //括号 左为K 右为V
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");

        Stack<Object> stack= new Stack<>();

        char[] chars =  s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.size() == 0){
                //为空时添加
                stack.add(chars[i]);
            }
            else {
                //不为空时比较
                String right = map.get(String.valueOf(stack.peek()));
                if (right == null){
                    return false;
                }
                String left = String.valueOf(chars[i]);
                //比较队列最上方的括号是不是于后一个相对应
                if (right.equals(left)){
                    //如果相对应，则弹出
                    stack.pop();
                }
                else{
                    //不对应就添加
                    stack.add(chars[i]);
                }
            }
        }
        //队列为空， 则表明都一一对应
        if (stack.size() == 0){
            return true;
        }
        //反之有不对应的
        else {
            return false;
        }

    }
}
