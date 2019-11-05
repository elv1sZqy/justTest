package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author zhuQiYun
 * @create 2019/11/5
 * @description :给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_290 {
    public static void main(String[] args) {
        new Test_290().wordPattern("", "dog");
    }

    public boolean wordPattern(String pattern, String str) {
        if (pattern.isEmpty() && !str.isEmpty()) {
            return false;
        }
        String[] patterns = pattern.split("");
        String[] target = str.split(" ");
        if(patterns.length != target.length) {
            return false;
        }
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i]) || map.containsValue(target[i])) {
                if (!Objects.equals(map.get(patterns[i]),target[i])){
                    return false;
                }
            }
            else {
                map.put(patterns[i],target[i]);
            }
        }

        return true;
    }
}
