package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_jz_105
 * @Author Elv1s
 * @Date 2021/9/4 11:37
 * @Description: 剑指 Offer II 105. 岛屿的最大面积
 * 给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。
 * <p>
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出: 6
 * 解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * 示例 2:
 * <p>
 * 输入: grid = [[0,0,0,0,0,0,0,0]]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1
 * <p>
 * <p>
 * 注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Test_jz_105 {

//    public int maxAreaOfIsland(int[][] grid) {
//        int N = grid.length;
//        int M = grid[0].length;
//        int maxArea = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (grid[i][j] == 1) {
//                    maxArea = Math.max(maxArea, infect(i, j, grid, N, M));
//                }
//            }
//        }
//        return maxArea;
//    }
//
//
//    private int infect(int i, int j, int[][] grid, int N, int M) {
//        if (i < 0 || i >= N ||
//                j < 0 || j >= M ||
//                grid[i][j] != 1) {
//            return 0;
//        }
//        grid[i][j] = 2;
//        return 1
//                + infect(i - 1, j, grid, N, M)
//                + infect(i + 1, j, grid, N, M)
//                + infect(i, j - 1, grid, N, M)
//                + infect(i, j + 1, grid, N, M)
//                ;
//    }


    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, infect(grid, i, j, grid.length, grid[i].length));
                }
            }
        }

        return max;
    }

    private int infect(int[][] grid, int i, int j, int X, int Y) {
        if (i > X - 1 || j > Y - 1 || i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 +
                // 右
                infect(grid, i + 1, j, X, Y) +
                // 下
                infect(grid, i, j + 1, X, Y) +
                // 上
                infect(grid, i, j - 1, X, Y) +
                // 左
                infect(grid, i - 1, j, X, Y);
    }

}
