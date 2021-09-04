package com.tsu.zqy.sort;

/**
 * @author zhuQiYun
 * @create 2021/8/30
 * @description :
 */
public class InsertionSort {

    public static void main(String[] args) {
        int maxValue = 10;
        int[] arr = SortUtil.getInts(maxValue);
        sort(arr);
        SortUtil.print(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                SortUtil.swap(arr, j, j - 1);
            }
        }
    }
}
