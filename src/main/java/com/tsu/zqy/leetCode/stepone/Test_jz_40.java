package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author zhuQiYun
 * @create 2021/10/21
 * @description :
 */
public class Test_jz_40 {

    @Test
    public void fun(){
        int[] nums = {4,1,5,2,6};
        getLeastNumbers(nums, 2);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1 > 0 ? 1 : -1;
        });
        for (int i : arr) {
            queue.add(i);
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = queue.poll();
        }
        return ints;
    }
}
