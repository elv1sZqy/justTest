package com.tsu.zqy.util;

/**
 * @ClassName MyCommonUtil
 * @Author Elv1s
 * @Date 2020/11/8 10:32
 * @Description:
 */
public class MyCommonUtil {
    public static void printTwoArrays(int[][] arrs) {
        char a = 'A';
        int length = arrs[0].length;
        for (int i = 0; i < arrs.length; i++) {
            System.out.print("\t" + a++);
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(i + ":");
            for (int i1 = 0; i1 < arrs.length; i1++) {
                System.out.print("\t" + arrs[i1][i]);
            }
            System.out.println();
        }
    }

}
