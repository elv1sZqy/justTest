package com.tsu.zqy.leetCode.stepthree;

import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2019/11/5
 * @description :给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_326 {

    @Test
    public void fun(){
        System.out.println(isPowerOfThree(81));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if ((n % 3 == 0)) {
            n = n / 3;
            if (n == 3) {
                return true;
            }
            return isPowerOfThree(n);
        }
        return false;

    }
}
