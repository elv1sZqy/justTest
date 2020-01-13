package com.tsu.zqy.leetCode.stepFour;

/**
 * @author zhuQiYun
 * @create 2019/12/13
 * @description :
 */
public class Test_443 {
    public static void main(String[] args) {
       char[] a = {'a','a','b','b','c','c','c'};
        System.out.println(new Test_443().compress(a));
    }
    public int compress(char[] chars) {
        int length = 0;

        int cLength = 0;
        char currentChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            if (currentChar == aChar) {
                length++;
            } else {
                String s = length + "";
                cLength = cLength + s.length() + 1;
                length = 1;
                currentChar = aChar;
            }
        }
        if (length != 0){
            String s = length + "";
            cLength += s.length() + 1;
        }
        return cLength;
    }
}
