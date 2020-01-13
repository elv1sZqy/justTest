package com.tsu.zqy.leetCode.recursion;

/**
 * @author zhuQiYun
 * @create 2020/1/13
 * @description :编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class Test1 {


    public static void main(String[] args) {
        String str = "JavaGuides";
        reverseString(str.toCharArray());
    }

    public static void reverseString(char[] s) {
        function(s, 0);

    }

    private static void function(char[] s, int i) {
        int length = s.length;
        if (i >= length / 2) {
            return;
        }
        char temp = s[i];
        s[i] = s[length - i - 1];
        s[length - i - 1] = temp;
        function(s, ++i);

    }
}
