package com.tsu.zqy.leetCode.stepthree;

import java.util.Objects;

/**
 * @author zhuQiYun
 * @create 2019/11/18
 * @description :给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_392 {
    public boolean isSubsequence(String s, String t) {
        int currentIndex = 0;
        int lengthOfT = t.length();
        while (currentIndex < s.length()) {
           t = t.substring(t.indexOf(s.charAt(currentIndex))+1);
           if (Objects.equals(t.length(),lengthOfT)) {
               return false;
           }
            lengthOfT = t.length();
           currentIndex++;
        }
        return currentIndex == s.length();
    }
    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int currentIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (Objects.equals(s.charAt(currentIndex), t.charAt(i))) {
                currentIndex ++;
                if (Objects.equals(currentIndex,s.length())) {
                    return true;
                }
            }
        }
        return false;
    }
}
