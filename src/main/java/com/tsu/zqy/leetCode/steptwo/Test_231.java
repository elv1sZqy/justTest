package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuQiYun
 * @create 2019/10/15
 * @description :
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_231 {

    public static void main(String[] args) {
        System.out.println(new Test_231().isPowerOfTwo(100));
    }

    /**
     * 解题思路：
     * 若 n = 2^xn=2
     * x
     *   且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
     * 恒有 n & (n - 1) == 0，这是因为：
     * nn 二进制最高位为 11，其余所有位为 00；
     * n - 1n−1 二进制最高位为 00，其余所有位为 11；
     * 一定满足 n > 0。
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        else {
            int i = Integer.bitCount(n);
            return i == 1;
        }
    }
}
