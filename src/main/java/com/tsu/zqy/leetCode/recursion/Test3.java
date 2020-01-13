package com.tsu.zqy.leetCode.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/1/13
 * @description :杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Test3 {

    @Test
    public void fun() {
        List<List<Integer>> generate = new Test3().generate(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        function(result, numRows);
        return result;
    }

    private void function(ArrayList<List<Integer>> result, int numRows) {
        int size = result.size();
        if (numRows == size) {
            return;
        }
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        List<Integer> upRow = result.get(size-1);
        int temp = 1;
        for (int i = 1; i < upRow.size(); i++) {
            Integer integer = upRow.get(i);
            row.add(temp + integer);
            temp = integer;
        }
        row.add(1);
        result.add(row);
        function(result, numRows);
    }
}
