package com.tsu.zqy.leetCode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/1/13
 * @description :  杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Test4 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new ArrayList<>();

        // 几个特殊情况
        if (rowIndex < 2){
            for (int i = 0; i < rowIndex + 1; i++) {
                resultList.add(1);
            }
        }
        else {
            List<Integer> currentList = Arrays.asList(1,1);
            for (int j = 2; j < rowIndex + 1; j++) {
                resultList = new ArrayList<>();
                for (int i = 0; i < currentList.size() + 1; i++) {
                    // 第一个和最后一个永远是1
                    if (i == 0){
                        resultList.add(1);
                    }
                    else if (i == currentList.size()){
                        resultList.add(1);
                    }
                    else {
                        resultList.add(currentList.get(i - 1) + currentList.get(i));
                    }

                }
                currentList = resultList;
            }
        }
        return resultList;
    }
}
