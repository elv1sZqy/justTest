package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/9/21
 * @description :输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Test_204 {

    public static void main(String[] args) {
        System.out.println(new Test_204().countPrimes(499979));
    }


    public int countPrimes1(int n) {
        if (n < 2) {
            return 0;
        }
        Map<Integer, Object> map = new HashMap<>();
        Object o = new Object();
        int[] arr = new int[n - 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!map.containsKey(num)) {
                map.put(num, o);
            }
            for (int i1 = i + 1; i1 < arr.length; i1++) {
                // 是i的倍数
                if (arr[i1] % num == 0) {
                    arr[i1] = num;
                }
            }
        }

        return map.size();
    }

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] arr = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                continue;
            }
            count++;
            for (int j = i; j < n; j += i) {
                if (j > 0 && j < n) {
                    arr[j] = true;
                } else {
                    continue;
                }
            }
        }
        return count;
    }


}
