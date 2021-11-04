package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2021/11/3
 * @description :
 *
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class Test_jz_04 {
    @Test
    public void fun(){
        int[] nums = {2,2,3,2};
        singleNumber(nums);
    }
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int num : nums) {
                a ^= num;
            }
        }
        return a;
    }
}
