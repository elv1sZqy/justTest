package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2021/10/22
 * @description :
 * <p>
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * 示例2:
 * <p>
 * 输入：A = 1，B = 2
 * 输出：2
 * 提示:
 * <p>
 * A，B范围在[-2147483648, 2147483647]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-integer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_05_06 {

    public int convertInteger(int A, int B) {
        return bitcount(A ^ B);
    }

    private static int bitcount(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }


    @Test
    public void fun(){
        System.out.println(bitcount(7));
    }

}
