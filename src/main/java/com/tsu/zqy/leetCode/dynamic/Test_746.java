package com.tsu.zqy.leetCode.dynamic;

/**
 * @author zhuQiYun
 * @create 2019/9/17
 * @description :
 */
public class Test_746 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        new Test_746().minCostClimbingStairs(cost);
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        } else if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        } else {
            int[] result = new int[cost.length];
            result[0] = cost[0];
            result[1] = cost[1];
            for (int i = 2; i < cost.length; i++) {
            }
            return 1;
        }

    }
}
