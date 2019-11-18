package com.tsu.zqy.leetCode.stepthree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/11/18
 * @description :给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_389 {
    public static void main(String[] args) {
        new Test_389().findTheDifference("abcd", "abcde");
    }

    public char findTheDifference(String s, String t) {
        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            a += s.charAt(i);
            b += t.charAt(i);
        }

        return (char) (b + t.charAt(s.length()) - a);
    }

    public char findTheDifference1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (map.containsKey(key)) {
                int i1 = map.get(key) + 1;
                map.put(key, i1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    int i1 = map.get(key) - 1;
                    map.put(key, i1);
                }
            }
        }

        for (Character character : map.keySet()) {
            return character.charValue();
        }
        return 1;
    }
}
