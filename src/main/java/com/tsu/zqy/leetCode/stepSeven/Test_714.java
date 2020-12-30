package com.tsu.zqy.leetCode.stepSeven;

/**
 * @author zhuQiYun
 * @create 2020/12/29
 * @description :
 */
public class Test_714 {
    public static void main(String[] args) {

    }

    /**
     * 贪心
     * <p>
     * 找到买入时间(价格在最低点)
     * 找到卖出时间(价格 - 买入价格 - 手续费 > 0 and 差值最大)
     * <p>
     * 遍历
     * 存在三种操作
     * 1. 是收益, 但不是最大
     * 2. 前一天是收益的最大值(今天的价格小于最小值), 今天就要记录最小值
     * 3. 不做操作
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int minPrice = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            // 买入
            if (price < minPrice) {
                minPrice = price;
            }

            // 买不便宜, 卖亏本  (可以去掉这部,   没删除是为了便于理解)
            if (price >= minPrice && price <= minPrice + fee) {
                continue;
            }

            // 开始盈利  (提前减去手续费)
            if (price > minPrice + fee) {
                sum += price - fee - minPrice;
                minPrice = price - fee;
            }

        }
        return sum;
    }
}
