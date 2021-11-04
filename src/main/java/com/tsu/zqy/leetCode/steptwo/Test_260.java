package com.tsu.zqy.leetCode.steptwo;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2021/11/3
 * @description :
 */
public class Test_260 {

    @Test
    public void fun() {
        int[] nums = {1,1,2,3,3,4,5,5};
        for (int i : singleNumber(nums)) {
            System.out.println(i);
        }
    }

    /**
     * 异或
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }

        return null;
    }

        public int[] singleNumber2(int[] nums) {
        int[] result = new int[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int num = nums[i];
            int num1 = nums[i + 1];
            if (num != num1) {
                for (int j = result.length - 1; j >= 0; j--) {
                    if (result[j] == num) {
                        result[j] = num1;
                        break;
                    }
                    if (result[j] == num1) {
                        result[j] = num;
                        break;
                    }
                    result[j] = j == 0 ? num : num1;
                }
            }
        }

        return result;
    }

    public int[] singleNumber1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                list.removeIf(i -> i == num);
                continue;
            }
            list.add(num);
        }
        System.out.println(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
