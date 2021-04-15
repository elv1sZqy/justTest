package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_14
 * @Author Elv1s
 * @Date 2019/6/13 9:01
 * @Description:
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""
 */
public class Test_14 {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        String str = strs[0];
        if (length == 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            for (int j = 1; j < strs.length; j++) {
                String tempStr = strs[j];
                if (i > tempStr.length() - 1 || currentChar != tempStr.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        return str;
    }

    private static String solution(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        else if(strs.length ==1){
            return strs[0];
        }

        String firstStr = strs[0];
        String templete = "";
        //最长公共前缀,  选择第一个  和后面的比就可以了
        for (int i = 1; i <= firstStr.length(); i++) {
            templete = firstStr.substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                boolean b = strs[j].startsWith(templete);
                if (!b){
                    if (i == 1){
                        return "";
                    }
                    else {
                        return strs[0].substring(0,i-1);
                    }
                }
            }
        }
        return firstStr;
    }


}
