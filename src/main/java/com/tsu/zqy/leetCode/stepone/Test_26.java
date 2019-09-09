package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_26
 * @Author Elv1s
 * @Date 2019/6/13 14:11
 * @Description: 26. 删除排序数组中的重复项c
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class Test_26 {
    public static void main(String[] args){
        int[] nums = {1,1};
        int length = removeDuplicates(nums);
        System.out.println(length);
    }

    public static int removeDuplicates(int[] nums) {
        //为空
        if (nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return 1;
        }

        //用于比较
        int temp = nums[0];
        //一个指针
        int index = 1 ;

        for (int i = 1; i < nums.length; i++) {
            //和第一个数相等的时候
            while (i <nums.length && temp == nums[i]){
                i++;
                if (i >=nums.length){
                    return index;
                }
            }
            //退出循环, 说明有新值
            //temp换成新值
            temp = nums[i];
            //将不重复的值放在前面
            nums[index] = temp;
            index++;
        }

        return index;
    }

}
