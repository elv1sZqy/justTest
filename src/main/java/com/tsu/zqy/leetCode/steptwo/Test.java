package com.tsu.zqy.leetCode.steptwo;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().func("dfsgfsjj667hjhkj904sfsf"));
    }

    public String func(String str){
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (47 < chars[i] && 58 > chars[i]){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
