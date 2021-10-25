package com.tsu.zqy.leetCode.steptwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2021/10/22
 * @description :
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class Test_229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int needleTimes = length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer times = map.getOrDefault(num, 0);
            map.put(num, times + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > needleTimes) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
