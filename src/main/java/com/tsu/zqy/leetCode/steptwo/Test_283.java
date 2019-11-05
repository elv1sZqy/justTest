package com.tsu.zqy.leetCode.steptwo;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author zhuQiYun
 * @create 2019/11/4
 * @description :给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Test_283 {
    public static void main(String[] args) {
        int[] arr = {0, 1};
        new Test_283().moveZeroes(arr);
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = i + 1;
            if (index == nums.length) {
                return;
            }
            if (nums[i] == 0) {
                while (nums[index] == 0) {
                    index++;
                    if (index == nums.length) {
                        return;
                    }
                }
                nums[i] = nums[index];
                nums[index] = 0;
            }
        }
    }

}
