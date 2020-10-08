package com.tsu.zqy.leetCode.stepSeven;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test_771
 * @Author Elv1s
 * @Date 2020/10/4 16:04
 * @Description:    给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_771 {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            List<Character> list = new ArrayList();
            char[] chars = J.toCharArray();
            for (char aChar : chars) {
                list.add(aChar);
            }
            char[] stoneArray = S.toCharArray();
            for (char c : stoneArray) {
                if (list.contains(c)){
                    count++;
                }
            }
            return count;
        }
    }

}
