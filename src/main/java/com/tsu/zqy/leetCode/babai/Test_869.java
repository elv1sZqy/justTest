package com.tsu.zqy.leetCode.babai;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhuQiYun
 * @create 2021/10/28
 * @description :
 */
public class Test_869 {
    @Test
    public void fun() {
        System.out.println(reorderedPowerOf2(46));
    }

    public boolean reorderedPowerOf2(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int[] used = new int[nums.length];
//        StringBuilder builder = new StringBuilder();
//        return collectNums(nums, used, builder);
        return backtrack(nums, used, 0, 0);
    }


    private boolean backtrack(char[] nums, int[] used, int currentNumCount, int num) {
        if (currentNumCount == nums.length) {
            return Integer.bitCount(num) == 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((currentNumCount == 0 && nums[i] == '0') || used[i] == 1) {
                continue;
            }
            used[i] = 1;
            if (backtrack(nums, used, ++currentNumCount, num * 10 + (nums[i] - '0'))) {
                return true;
            };
            used[i] = 0;
            --currentNumCount;
        }
        return false;
    }


    private boolean collectNums(char[] nums, int[] used, StringBuilder builder) {
        for (int i = 0; i < nums.length; i++) {
            if (builder.length() == nums.length) {
                Integer aNum = Integer.valueOf(builder.toString());
                int count = Integer.bitCount(aNum);
                return count == 1;
            }
            if ((builder.length() == 0 && nums[i] == '0') || used[i] == 1) {
                continue;
            }
            StringBuilder builder2 = new StringBuilder(builder);
            builder.append(nums[i]);
            used[i] = 1;
            if (collectNums(nums, used, builder)) {
                return true;
            }
            builder = builder2;
            used[i] = 0;
        }
        return false;
    }
}
