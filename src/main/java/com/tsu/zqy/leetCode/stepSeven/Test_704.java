package com.tsu.zqy.leetCode.stepSeven;

/**
 * @author zhuQiYun
 * @create 2021/9/6
 * @description :
 */
public class Test_704 {
    public static void main(String[] args) {
        new Test_704().search(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left == right) {
            return target == nums[left] ? left : -1;
        }
        int i = (left + right) / 2;
        int inLeft = binarySearch(nums, left, i, target);
        int inRight = binarySearch(nums, i + 1, right, target);
        return Math.max(inLeft, inRight);
    }
}
