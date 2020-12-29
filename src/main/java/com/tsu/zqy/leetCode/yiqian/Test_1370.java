package com.tsu.zqy.leetCode.yiqian;

/**
 * @author zhuQiYun
 * @create 2020/11/25
 * @description :
 * 给你一个字符串s，请你根据下面的算法重新构造字符串：
 * <p>
 * 从 s中选出 最小的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s中选择字符。
 * 从 s中选出 最大的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
 * 重复步骤 5，直到你没法从 s中选择字符。
 * 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将s中字符重新排序后的 结果字符串 。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 * <p>
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 * <p>
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 * <p>
 * 输入：s = "spo"
 * 输出："ops"
 * 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_1370 {
    /**
     *  * 给你一个字符串s，请你根据下面的算法重新构造字符串：
     *  * <p>
     *  * 从 s中选出 最小的字符，将它 接在结果字符串的后面。
     *  * 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
     *  * 重复步骤 2 ，直到你没法从 s中选择字符。
     *  * 从 s中选出 最大的字符，将它 接在结果字符串的后面。
     *  * 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
     *  * 重复步骤 5，直到你没法从 s中选择字符。
     *  * 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
     *  * 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
     * @param s
     * @return
     */
    /*public String sortString(String s) {
        // 用一个flag表示找最大还是找最小
        boolean findMin = true;
        // 用一个值表示当前最大/最小值
        char curr = 0;
        char temp = 100;
        // 保存结果
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '*') {
                continue;
            }
            if (findMin) {
                temp = Math.min(temp, )
            }
            if ()
        }
        return result.toString();
    }*/
}
