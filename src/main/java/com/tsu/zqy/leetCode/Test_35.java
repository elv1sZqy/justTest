package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_35
 * @Author Elv1s
 * @Date 2019/6/13 18:13
 * @Description: 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class Test_35 {

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 0;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        //特殊情况
        if (nums.length == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }

        return nums.length;
    }
}
