package com.tsu.zqy.leetCode.babai;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2020/12/31
 * @description :
 */
public class Test_860 {
    public static void main(String[] args) {
        int[] nums = {5, 5, 10, 10, 20};
        Test_860 test_860 = new Test_860();
        test_860.lemonadeChange(nums);
    }

    /**
     * 贪心
     * 维护一个map, 记录钞票的面额和数量
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    five--;
                    if (five < 0) {
                        return false;
                    }
                    ten++;
                    break;
                default:
                    if (ten > 0) {
                        ten--;
                        if (five > 0) {
                            five--;
                        } else {
                            return false;
                        }
                    } else {
                        five -= 3;
                        if (five < 0) return false;
                    }
            }
        }
        return true;
    }

    @Test
    public void test_list() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<List<Integer>> partition = Lists.partition(list, 500);

        List<Integer> duplicateId = new ArrayList<>();
        // 分批保存到数据库
        List<Integer> containedIds = null;
        for (List<Integer> integers : partition) {
            containedIds = integers;
            duplicateId.addAll(containedIds);
            integers.removeAll(containedIds);
        }
    }
}
