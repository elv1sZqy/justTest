package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_53
 * @Author Elv1s
 * @Date 2019/6/13 19:31
 * @Description: 53. 最大子序和
 */
public class Test_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = maxSubArray(nums);
        System.out.println(sum);
    }
    public static int maxSubArray(int[] nums) {

        //记录最大数
        int max = nums[0];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > max){
                    max = sum;
                }
            }
            sum = 0;
        }
        return max;
    }
}
