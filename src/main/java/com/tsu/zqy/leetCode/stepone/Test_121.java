package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

/**
 * @ClassName Test_121
 * @Author Elv1s
 * @Date 2019/8/18 19:31
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_121 {


    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 1};
        System.out.println(new Test_121().maxProfit(arr));
    }

    /**
     * for循环遍历
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                maxProfit = temp > maxProfit ? temp : maxProfit;
            }
        }

        if (maxProfit < 0) {
            return 0;
        }
        return maxProfit;
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));

    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int[] profit = new int[prices.length];
            profit[0] = 0;
            // 利润的数组
            for (int i = 1; i < profit.length; i++) {
                profit[i] = prices[i] - prices[i - 1];
            }
            int pre = profit[0];
            int max = profit[0];
            for (int i = 1; i < profit.length; i++) {
                pre = Math.max(profit[i], pre + profit[i]);
                max = Math.max(max, pre);
            }
            return max > 0 ? max : 0;
        }

        public int maxProfit2(int[] prices) {
            int length = prices.length;
            if (prices == null || length <= 1) return 0;
            int [] dp = new int[length];
            int min = prices[0];
            dp[0] = -prices[0];
            for (int i = 1; i < length; i++) {
                min = Math.min(min, prices[i]);
                dp[i] =  Math.max(dp[i-1], prices[i] - min);
            }
            return dp[length - 1];
        }

    }



}
