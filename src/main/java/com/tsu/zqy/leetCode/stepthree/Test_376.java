package com.tsu.zqy.leetCode.stepthree;

/**
 * @author zhuQiYun
 * @create 2021/1/4
 * @description :
 */
public class Test_376 {
    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(new Test_376().wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int result = 1;
        int preDiff = 0, currDiff = 0;
        for (int i = 1; i < length; i++) {
            currDiff = nums[i] - nums[i - 1];
            if ((preDiff >= 0 && currDiff < 0) || (preDiff <= 0 && currDiff > 0)) {
                result++;
                preDiff = currDiff;
            }
        }
        return result;
    }

}
