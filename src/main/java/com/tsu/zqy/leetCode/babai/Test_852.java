package com.tsu.zqy.leetCode.babai;

/**
 * @ClassName Test_852
 * @Author Elv1s
 * @Date 2021/7/14 20:34
 * @Description:
 */
public class Test_852 {

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }

}
