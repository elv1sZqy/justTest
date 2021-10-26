package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2021/1/4
 * @description :
 */
public class Test_55 {
    public static void main(String[] args) {
        int a = 'a';
        System.out.println(a);
        a = 'A';
        System.out.println(a);
        new Test_55().canJump1(new int[]{3, 2, 1, 0, 4});
    }

    @Test
    public void fun(){
        int[] ints = {3, 2, 1, 0, 4};
        canJump(ints);
    }

    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxDistance) {
                return false;
            }
            int num = nums[i];
            maxDistance = Math.max(maxDistance, i + num);
        }
        return maxDistance >= nums.length-1;
    }


    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
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
