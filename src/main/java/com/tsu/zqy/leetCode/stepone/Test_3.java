package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName Test_3
 * @Author Elv1s
 * @Date 2020/10/4 14:53
 * @Description:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_3 {
    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int startIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.getOrDefault(aChar, -1) >= startIndex) {
                Integer index = map.get(aChar);
                startIndex = ++index;
            }
            max = Math.max(max, i - startIndex + 1);
            map.put(aChar, i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("".length());
        System.out.println(" ".length());

    }

    class Solution {
        public int lengthOfLongestSubstring1(String s) {
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

        public int lengthOfLongestSubstring2(String s) {
            int length = s.length();
            if (length == 0 || length == 1) {
                return length;
            }
            char[] chars = s.toCharArray();
            int start = 0, end = 0, max = 0;
            Map<Character, Integer> cache = new HashMap<>(length);
            for (; end < length; end++) {
                Character currentChar = chars[end];
                // 如果存在就将start改为该char先前位置的后一位
                if (cache.containsKey(currentChar)) {
                    Integer oldIndex = cache.get(currentChar);
                    max = Math.max(max, end - start);
                    if (oldIndex >= start) {
                        start = oldIndex + 1;
                    }
                    cache.put(currentChar, end);
                    continue;
                }
                cache.put(currentChar, end);
            }
            return Math.max(max, end - start);
        }
    }
}