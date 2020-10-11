package com.tsu.zqy.leetCode.stepFour;

import java.util.Arrays;

/**
 * @ClassName Test_416
 * @Author Elv1s
 * @Date 2020/10/11 16:32
 * @Description: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_416 {

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            if (sum % 2 == 0) {
                int half = sum / 2;
                Arrays.sort(nums);
            }
            return false;
        }
    }

        public static void main (String[]args){
            System.out.println("最终结果是：" + packageProblem1());
        }

         public static int packageProblem1 () {
            int packageContainWeight = 4;//包最大可装重量
            int[] weight = {1, 4, 3};//3个物品的重量
            int[] value = {150, 300, 200};//3个物品的价值
            int[][] dp = new int[weight.length + 1][packageContainWeight + 1];
            // 价值
            for (int i = 1; i <= value.length; i++) {
                // 质量
                for (int j = 1; j <= packageContainWeight; j++) {
                    if (j >= weight[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            //Util.printTwoIntArrays(dp);//这一行仅做打印观测数据，也可以去掉
            return dp[weight.length][packageContainWeight];
        }

}
