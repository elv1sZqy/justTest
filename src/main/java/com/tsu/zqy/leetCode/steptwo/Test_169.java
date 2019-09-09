package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test_169
 * @Author zhuQiYun
 * @Date 2019/8/21 14:16
 * @Description: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class Test_169 {


    /**
     * 思路 : 数组中的值作为key ,  出现次数作为vaule 存在map中
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // map中不存在数组的值,加入map
            if (!map.containsKey(nums[i])) {
                // 次数默认一次
                map.put(nums[i], 1);
            } else {
                // 对应次数加一
                Integer times = map.get(nums[i]);
                map.put(nums[i], times + 1);
            }
        }
        // 找出次数最多的值
        int max = 0;
        for (Integer time : map.values()){
            max = max > time ? max : time;
        }

        for(Integer getKey: map.keySet()){
            if(map.get(getKey).equals(max)){
                result = getKey;
            }
        }

        return result;
    }

}
