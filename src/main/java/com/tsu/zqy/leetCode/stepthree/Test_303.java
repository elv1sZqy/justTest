package com.tsu.zqy.leetCode.stepthree;

/**
 * @author zhuQiYun
 * @create 2019/11/5
 * @description :给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_303 {
    private int[] nums;

    public Test_303(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Test_303 test_303 = new Test_303(nums);
        test_303.sumRange(0 ,2);
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (i1 > j) {
                return sum;
            }
            if (i1 >= i) {
                sum += nums[i1];
            }
        }
        return sum;
    }
}
