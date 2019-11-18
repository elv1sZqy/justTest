package com.tsu.zqy.leetCode.stepthree;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_371 {
    public static void main(String[] args) {
        System.out.println(new Test_371().getSum(3, 5));
    }
    public int getSum(int a, int b) {
        int sum, carry;
        sum = a ^ b;

        carry = (a & b) << 1;

        if (carry != 0){
            return getSum(sum,carry);
        }
        return sum;
    }

}
