package com.tsu.zqy.sort;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author zhuQiYun
 * @create 2021/8/30
 * @description :
 */
public class SortUtil {

    public static int[] getInts(int maxValue) {
        Random random = new Random();
        int[] arr =  new int[maxValue];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue * 2);
        }
        return arr;
    }

    public static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void print(int[] arr) {
        StringJoiner joiner = new StringJoiner("\t");
        for (int i = 0; i < arr.length; i++) {
            joiner.add(arr[i] +"");
        }
        System.out.println(joiner);
    }
}
