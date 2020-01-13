package com.tsu.zqy.leetCode.stepFour;

import java.util.Objects;

/**
 * @author zhuQiYun
 * @create 2019/11/29
 * @description :统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_434 {
    public int countSegments(String s) {
        s = s.trim();
        if (Objects.equals(s.length(),0)) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return  s1.length;
    }
    public int countSegments2(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

}
