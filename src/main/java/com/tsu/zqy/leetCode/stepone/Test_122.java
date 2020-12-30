package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.util.MyCommonUtil;

/**
 * @ClassName Test_122
 * @Author Elv1s
 * @Date 2019/8/18 20:47
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_122 {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(new Test_122().maxProfit2(arr));
    }

    /**
     * 思路:  1.先找一个最小值.
     * 2.再找一个比当前最小值还要小的值,当存在这个值时,在他和之前的最小值之间,
     * 找一个最大值.
     * 3.第一次的买入是之前的最小值, 卖出是最大值.
     * 4.以此类推
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // 总利润
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            int prev = prices[i - 1];
            int num = current - prev;
            if (num > 0) {
                maxProfit += num;
            }
        }

        return maxProfit;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (prices == null || length <= 1) {
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 今天结束后不持有股票
            // case 1 前一天就没持有. 那么收益还是前一天的状态
            // case 2 前一天持有, 那么就是今天把股票卖了, 收益就是前一天的收益加上今天股票的价格
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            // 今天结束后持有股票
            // case 1 前一天就没持有. 今天买入,当前收益就是买入时的价格
            // case 2 前一天持有, 今天也持有, 那么收益还是前一天的
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        MyCommonUtil.printTwoArrays(dp);
        return dp[length-1][0];
    }

    /**
     * 贪心
     * 从第二天开始, 当天的价格减去前一天的价格, 如果是整数,就利息就加上差值, 如果是负数,就继续循环
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int accrual = prices[i] - prices[i - 1];
            if (accrual > 0) {
                sum+=accrual;
            }
        }
        return sum;
    }



}
