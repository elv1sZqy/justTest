package com.tsu.zqy.leetCode.stepFour;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhuQiYun
 * @create 2019/12/18
 * @description :
 */
public class Test_453 {

    public static void main(String[] args) {
        int[] ints = {1,4,2,5,8,2};
        System.out.println(new Test_453().minMoves(ints));
    }

    public int minMoves(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count += nums[i] - min;
        }
        return count;
    }
}
