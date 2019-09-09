package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_136
 * @Author zhuQiYun
 * @Date 2019/8/19 10:56
 * @Description:
 */
public class Test_136 {
    public static void main(String[] args){
        int[] arr = {-1,-1,-2};
        System.out.println(new Test_136().singleNumber(arr));
    }
    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j && j != nums.length -1){
                    continue;
                }
                // 如果存在相似的, 就跳出当前循环
                if (i != j && nums[i] == nums[j]){
                    break;
                }
                // 到最后都没找到第二个, 就返回值
                if (j == nums.length -1){
                    return nums[i];
                }

            }
        }
        return 1;
    }
}
