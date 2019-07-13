package com.tsu.zqy.dataStructures;

/**
 * @ClassName SparaeArray
 * @Author Elv1s
 * @Date 2019/7/10 15:47
 * @Description:  二维数组 转 稀疏数组 再转成 二维数组
 */
public class SparaeArray {
    public static void main(String[] args){
        // 新建一个11*11 的二维数组
        int[][] chessArray = new int[11][11];
        /*
            第2行第3列一个黑子
            第3行第4列一个白子
            1为黑子  2为白子  0为空
         */
        chessArray[1][2] = 1;
        chessArray[0][0] = 1;
        chessArray[2][3] = 2;

        //展示棋盘
        for (int[] arr1 : chessArray) {
            for (int data : arr1){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /*
            稀疏数组格式:
         */
        // 二维数组转成稀疏数组
        // sum为二维数组中的值的个数, 即非0的个数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int i1 = 0; i1 < chessArray[0].length; i1++) {
                // 计算非0个数
                if (chessArray[i][i1] != 0){
                    sum++;
                }
            }
        }
        // 新建稀疏数组
        int[][] sparaeArray = new int[sum + 1][3];

        sparaeArray[0][0] = chessArray.length;
        sparaeArray[0][1] = chessArray[0].length;
        sparaeArray[0][2] = sum;

        // 稀疏数组的下标
        int index = 1;

        for (int i = 0; i < chessArray.length; i++) {
            for (int i1 = 0; i1 < chessArray[0].length; i1++) {
                if (chessArray[i][i1] != 0){
                    sparaeArray[index][0] = i;
                    sparaeArray[index][1] = i1;
                    sparaeArray[index][2] = chessArray[i][i1];
                    index++;
                }
            }
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // 展示稀疏数组
        for (int[] arr1 : sparaeArray) {
            for (int data : arr1){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 稀疏数组转成二维数组
        int[][] chessArray2 = new int[ sparaeArray[0][0]] [sparaeArray[0][1] ];

        for (int i = 1; i <= sparaeArray[0][2]; i++) {
            chessArray2[sparaeArray[i][0]][sparaeArray[i][1]] = sparaeArray[i][2];
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int[] arr1 : chessArray2) {
            for (int data : arr1){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
