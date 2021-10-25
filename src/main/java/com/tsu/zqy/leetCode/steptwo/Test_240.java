package com.tsu.zqy.leetCode.steptwo;

import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2021/10/25
 * @description :
 * <p>
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Test_240 {

    @Test
    public void fun() {
//        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] nums = {{-5}};
        System.out.println(searchMatrix(nums, 5));
    }

    /**
     * 从右上角逐一向下找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int Y = matrix.length;
        int X = matrix[0].length;
        int x = X - 1;
        int y = 0;
        while (x >= 0 && y <= Y - 1) {
            int num = matrix[y][x];
            if (num == target) {
                return true;
            }
            if (num > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
