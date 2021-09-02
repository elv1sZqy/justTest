package com.tsu.zqy.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author zhuQiYun
 * @create 2021/8/30
 * @description :
 */
public class SelectionSort {
    public static void main(String[] args) {
        int maxValue = 100;
        int[] arr = SortUtil.getInts(maxValue);
        sort(arr);
        SortUtil.print(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            if (minIndex != i) {
                SortUtil.swap(arr, minIndex, i);
            }
        }
    }
}
