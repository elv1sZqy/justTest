package com.tsu.zqy.leetCode.stepone;

import java.util.PriorityQueue;

/**
 * @author zhuQiYun
 * @create 2021/9/3
 * @description :面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class Test_17_14 {

    public static void main(String[] args) {
        int[] ints = new Test_17_14().smallestK(new int[]{1, 2, 4, 5, 7, 8, 9}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}