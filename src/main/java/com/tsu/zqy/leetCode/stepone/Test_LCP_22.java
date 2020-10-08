package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

/**
 * @ClassName Test_LCP_22
 * @Author Elv1s
 * @Date 2020/10/8 15:56
 * @Description: 小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。
 * <p>
 * 小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
 * <p>
 * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, k = 2
 * <p>
 * 输出：4
 * <p>
 * 解释：一共有四种不同的方案：
 * 第一种方案：涂第一列；
 * 第二种方案：涂第二列；
 * 第三种方案：涂第一行；
 * 第四种方案：涂第二行。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 1
 * <p>
 * 输出：0
 * <p>
 * 解释：不可行，因为第一次涂色至少会涂两个黑格。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 2, k = 4
 * <p>
 * 输出：1
 * <p>
 * 解释：共有 2*2=4 个格子，仅有一种涂色方案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ccw6C7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_LCP_22 {
    @Test
    public void test() {
        System.out.println(Solution.paintingPlan(2, 2));
    }

    /**
     * 思路 :  先画竖的格子, 判断规则是剩余格子数 / n 是否 > n 如果是 , 就继续画竖的, 如果不是就画横的
     * 横的格子数实际增加的个数为n-竖的个数
     */
    static class Solution {
        public static int paintingPlan(int n, int k) {
            int res = 0;
            //边界问题
            if (k == 0) {
                return 1;
            }
            if (k == n * n) {
                return 1;
            }

            //第一层循环表示涂 i 行 第二层循环表示涂 j 列
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    //当你涂了 i 行 j 列  则有 i * n + j * n个方格被涂过了
                    //去掉重复计入的 i*j个方格 是否等于结果k
                    if ((i * n) + (j * n) - (i * j) == k) {
                        res += C(i, n) * C(j, n);
                    }
                }
            }
            return res;
        }

        /**
         * 数学里的排列组合 C(愚蠢式写法，勿计较)
         * @param x 使用的条数
         * @param y 方形的边长
         * @return
         */
        public static int C(int x, int y) {
            if (x == 0) {
                return 1;
            }
            int n = 1;
            for (int i = 0; i < x; i++) {
                n *= (y - i);
            }
            for (int i = 1; i <= x; i++) {
                n /= i;
            }
            return n;
        }
    }
}