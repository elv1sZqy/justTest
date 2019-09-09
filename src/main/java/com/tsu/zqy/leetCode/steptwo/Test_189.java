package com.tsu.zqy.leetCode.steptwo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test_189 {
    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 5, 6, 7};
        int k = 1;
        new Test_189().rotate(arrs, k);
        System.out.println(arrs.toString());
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            disposeFunction(nums);
        }

    }

    /**
     * 一步一步移动
     *
     * @param nums
     */
    private void disposeFunction(int[] nums) {
        // 最后一个元素
        int currentNum = nums[0];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (i == 0) {
                int second = nums[1];
                // 最后一个元素移到第一个
                nums[i] = nums[length - 1];
                // 第一个元素移到第二个
                nums[i + 1] = currentNum;
                currentNum = second;
            } else {
                int temp = nums[i + 1];
                nums[i + 1] = currentNum;
                currentNum = temp;
            }
        }
    }


    public void rotate2(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
