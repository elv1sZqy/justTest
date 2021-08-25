package com.tsu.zqy.leetCode.babai;


import java.util.StringJoiner;

/**
 * @ClassName Test_1111
 * @Author Elv1s
 * @Date 2021/8/25 19:18
 * @Description: 用异或做的两个题
 */
public class Test_1111 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        test1(arr1);
        int[] arr2 = {1, 2, 3, 4, 5, 6, 4, 3, 2, 1};
        test2(arr2);


        // 选择排序 O(n2) , 用一个值记录这次遍历的最小值的下标
        int[] arr3 = {6, 3, 1, 8, 4, 2, 5, 9, 7};
        for (int i = 0; i < arr3.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr3.length; j++) {
                minIndex = arr3[minIndex] > arr3[j] ? j : minIndex;
            }
            if (i != minIndex) {
                swap(arr3, i, minIndex);
            }
        }
        print(arr3);

        System.out.println("=====");

        // 冒泡  一层一层冒泡上去 O(n2)
        int[] arr4 = {6, 3, 1, 8, 4, 2, 5, 9, 7};
        for (int i = 0; i < arr4.length - 1; i++) {
            for (int j = 0; j < arr4.length - 1; j++) {
                if (arr4[j] > arr4[j + 1]) {
                    swap(arr4, j, j + 1);
                }
            }
        }
        print(arr4);

        int[] arr5 = {6, 3, 1, 8, 4, 2, 5, 9, 7};

        // 插入排序  保证前一段(j以前)是有序的 最差 O(n2) , 最好O(n)
        for (int i = 0; i < arr5.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr5[j] < arr5[j - 1]; j--) {
                swap(arr5, j, j - 1);
            }
        }
        print(arr5);
    }

    private static void print(int[] arr) {
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (int i : arr) {
            joiner.add(i + "");
        }
        System.out.println(joiner);
        System.out.println("(1,2,3,4,5,6,7,8,9)".equals(joiner.toString()));
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 找两个
     *
     * @param arr2
     */
    private static void test2(int[] arr2) {
        // 第一遍异或找到num =  a ^ b
        int num = 0;
        for (int i : arr2) {
            num ^= i;
        }

        // 找到从右开始数的第一个1
        int flag = num & (~num + 1);
        int oneOfThem = 0;
        for (int i : arr2) {
            if ((i & flag) != 0) {
                oneOfThem ^= i;
            }
        }
        System.out.println("a = " + oneOfThem);
        System.out.println("b = " + (oneOfThem ^ num));
    }

    /**
     * 找出数组中唯一一个出现基数次数的
     *
     * @param arr
     */
    private static void test1(int[] arr) {
        int num = 0;

        for (int i : arr) {
            num ^= i;
        }
        System.out.println(num);
    }


}
