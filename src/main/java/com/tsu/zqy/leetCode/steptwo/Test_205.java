package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/9/29
 * @description :
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_205 {

    public static void main(String[] args) {
        System.out.println(new Test_205().isIsomorphic("hxha", "hehe"));
    }

    /**
     * 思路  :  新建一个map , key 为 s 中的值, v 为t的值
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])){
                if (map.get(sChars[i]) == tChars[i]){
                    continue;
                }
                return false;
            }
            else {
                if (map.containsValue(tChars[i])){
                    return false;
                }
                map.put(sChars[i], tChars[i]);
            }
        }

        return true;
    }
}
