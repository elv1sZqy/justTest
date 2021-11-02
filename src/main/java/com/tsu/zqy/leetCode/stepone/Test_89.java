package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2021/10/26
 * @description :
 */
public class Test_89 {
    int[] usedMap = null;

    @Test
    public void fun() {
        grayCode(3);
    }

    public List<Integer> grayCode(int n) {
        int pow = (int) Math.pow(2, n);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        addOne(list, n);
        removeOne(list, n, pow - 1);
        return list;
    }

    private void removeOne(List<Integer> list, int n, int t) {
        for (int i = 0; i < n; i++) {
            if (0 == i && t % 2 == 0) {
                continue;
            }
            int num = t - (int) Math.pow(2, i);
            if (num > 0 && !list.contains(num)) {
                list.add(num);
                removeOne(list, n, num);
            }
        }
    }

    private void addOne(List<Integer> list, int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (int) Math.pow(2, i);
            if (!list.contains(num)) {
                list.add(num);
            }
        }

    }

    private void func(List<Integer> list, int n) {

    }
}
