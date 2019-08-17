package com.tsu.zqy.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test_119
 * @Author Elv1s
 * @Date 2019/8/17 20:52
 * @Description:
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class Test_119 {

    public static void main(String[] args){
        System.out.println(new Test_119().getRow(5));
    }
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
