package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhuQiYun
 * @create 2019/11/4
 * @description :给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = getAlphabetCountMap(s);
        Map<Character, Integer> map2 = getAlphabetCountMap(t);
        return Objects.equals(map1,map2);
    }

    private Map<Character, Integer> getAlphabetCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                Integer count = map.get(aChar);
                map.put(aChar,++count);
            }
            else {
                map.put(aChar, 1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        boolean anagram = new Test_242().isAnagram("aaac","aacc");
        System.out.println(anagram);
    }
}