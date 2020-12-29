package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/9/29
 * @description :
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_217 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,56,6,1,5};
        System.out.println(new Test_217().containsDuplicate(nums));
    }

    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                return true;
            }
            map.put(num, nums);
        }
        return false;
    }


    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Object> map = new HashMap<>(nums.length);
        for (int num : nums) {
           if (null != map.put(num, this)) {
               return true;
           }
        }
        return false;
    }
}
