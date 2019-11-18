package com.tsu.zqy.leetCode.stepthree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/11/8
 * @description :给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            setMap(map1, key);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char key = magazine.charAt(i);
            setMap(map2, key);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer times = entry.getValue();
            if (map2.containsKey(key)) {
                if (map2.get(key) < times) {
                    return false;
                }
            }
            else {
                return false;
            }

        }
        return true;
    }

    private void setMap(Map<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
