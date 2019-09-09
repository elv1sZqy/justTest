package com.tsu.zqy.leetCode.steptwo;

/**
 * @ClassName Test_172
 * @Author zhuQiYun
 * @Date 2019/8/22 19:53
 * @Description: 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 */
public class Test_172 {

    public static void main(String[] args) {
        System.out.println(new Test_172().trailingZeroes(10 ));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res = res + n / 5;
            n = n / 5;
        }
        return res;
    }

   /* public int trailingZeroes(int n) {
        // 阶乘
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }

        // 转换为数组 , 倒着计数
        int count = 0;
        char[] chars = (sum + "").toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0'){
                count++;
            }
            else {
                return count;
            }
        }

        return 0;
    }*/


}
