package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_122
 * @Author Elv1s
 * @Date 2019/8/18 20:47
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_122 {

    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4};
        System.out.println(new Test_122().maxProfit(arr));
    }
    /**
    * 思路:  1.先找一个最小值.
     *       2.再找一个比当前最小值还要小的值,当存在这个值时,在他和之前的最小值之间,
     *       找一个最大值.
     *       3.第一次的买入是之前的最小值, 卖出是最大值.
     *       4.以此类推
    */
    public int maxProfit(int[] prices) {
        // 总利润
        int maxProfit = 0;
        // 当前的最小值对应的下标
        //1.先找一个最小值.
        int currentMin = 0;
        // 当前最大值对应的下标
        int currentMax = 0;
        for (int i = 1; i < prices.length; i++) {
            // 2.再找一个比当前最小值还要小的值,当存在这个值时,再他和之前的最小值之间,找一个最大值.
            if (prices[i] < currentMin){

            }
            // 最大值
            currentMax = prices[i] > currentMax ? prices[i] : currentMax;


        }

        return 0;
    }

}
