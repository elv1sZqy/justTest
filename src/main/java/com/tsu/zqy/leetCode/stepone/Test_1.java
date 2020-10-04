package com.tsu.zqy.leetCode.stepone;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test_1
 * @Author Elv1s
 * @Date 2020/10/3 16:56
 * @Description:
 */
public class Test_1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];
                int needNum = target - currentNum;
                if (map.containsKey(needNum)) {
                    return new int[]{map.get(needNum), i};
                } else {
                    map.put(currentNum, i);
                }
            }
            return null;
        }
    }

}
