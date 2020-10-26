package com.tsu.zqy.leetCode.yiqian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2020/10/26
 * @description :
 */
public class Test_1365 {

    // 先做排序    不算排序...  O(n)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++) {
            int num = copy[i];
            if (0 == i) {
                cache.put(num, 0);
                continue;
            }
            if (cache.containsKey(num)) continue;
            cache.put(num, i);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = cache.get(nums[i]);
        }
        return result;
    }

    // 暴力法
    // 加一个缓存cache   O(n^2)
    public int[] smallerNumbersThanCurrent1(int[] nums) {
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
