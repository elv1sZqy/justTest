package com.tsu.zqy.leetCode.steptwo;

/**
 * @author zhuQiYun
 * @create 2019/9/17
 * @description :
 */
public class Test_198 {

    public static void main(String[] args) {
        int[] ins = {2, 7, 6, 9, 3, 11, 3, 7, 8};
        new Test_198().rob(ins);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }
        return memo[n - 1];
    }

    /**
     * 动态规划简化版
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        }
        return memo[n - 1];
    }
}
