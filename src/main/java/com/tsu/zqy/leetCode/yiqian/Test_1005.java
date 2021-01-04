package com.tsu.zqy.leetCode.yiqian;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/12/31
 * @description :
 */
public class Test_1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (K == 0) {
                break;
            }
            int num = A[i];
            if (num < 0 && K > 0) {
                A[i] = -num;
                K--;
            }
        }
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (K > 0 && i == 0) {
                if (K %2 != 0) {
                    num = -num;
                }
            }
            sum += num;
        }
        return sum;
    }
}
