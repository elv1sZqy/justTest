package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

import java.util.HashSet;

/**
 * @ClassName Test_3
 * @Author Elv1s
 * @Date 2020/10/4 14:53
 * @Description:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_3 {
    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));

    }

    public static void main(String[] args){
        System.out.println("".length());
        System.out.println(" ".length());

    }
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int length = s.length();
            char[] chars = s.toCharArray();
            if (length == 0 || length == 1) return length;
            // 定义两个指针, 一个start 一个end;
            int start = 0, end = 1, max = 0;
            set.add(chars[start]);
            // 先确定起始位置, 移动end指针, 直至出现起始位置对应的字符
            while (start < length && end < length) {
                // 然后start向后移动一位, end从原先的位置继续向后
                if (!set.add(chars[end])) {
                    max = Math.max(max, end - start);
                    set.remove(chars[start]);
                    start += 1;
                    continue;
                }
                end++;
            }
            // 取最大值
            return Math.max(max, end - start);
        }
    }
}
