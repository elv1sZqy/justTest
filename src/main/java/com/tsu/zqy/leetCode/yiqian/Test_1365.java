package com.tsu.zqy.leetCode.yiqian;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2020/10/26
 * @description :
 */
public class Test_1365 {
    // 暴力法
    // 加一个缓存cache
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            if (cache.containsKey(num)) {
                count = result[i] = cache.get(num);
            } else {
                for (int j : nums) {
                    if (j < num) {
                        count++;
                    }
                }
                cache.put(num, count);
            }
            result[i] = count;
        }
        return result;
    }
}
