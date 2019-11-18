package com.tsu.zqy.leetCode.stepthree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhuQiYun
 * @create 2019/11/18
 * @description :给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_387 {
    public static void main(String[] args) {
        System.out.println(new Test_387().firstUniqChar("loveleetcode"));
    }
    public int firstUniqChar(String s) {
        Map<Character,Object> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                continue;
            }
            int oldSize = map.size();
            for (int j = i + 1; j < s.length(); j++) {
                if (Objects.equals(s.charAt(j), key)) {
                    map.put(key,null);
                }
            }
            int newSize = map.size();
            if (newSize == oldSize) {
                return i;
            }
        }

        return -1;
    }
}
