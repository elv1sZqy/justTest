package com.tsu.zqy.leetCode.stepone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2021/1/4
 * @description :
 */
public class Test_55 {
    public static void main(String[] args) {
        new Test_55().canJump(new int[]{3,2,1,0,4});
    }

    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int cover = 0;
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i] + i, cover);
            if (cover >= length - 1) {
                return true;
            }
        }

        return false;
    }
}
