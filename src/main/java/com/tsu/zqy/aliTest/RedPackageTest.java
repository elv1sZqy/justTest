package com.tsu.zqy.aliTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackageTest {
    public static void main(String[] args) {
        System.out.println("微信红包算法：");
        dealRedPackage(100,7);
    }

    private static int offset = 10;

    private static List<Double> luckNumList;

    static {
        luckNumList = new ArrayList();
        luckNumList.add(6.66);
        luckNumList.add(8.88);
        luckNumList.add(66.66);
        luckNumList.add(88.88);
    }

    //请补充下列函数内容
    public static void dealRedPackage(double money,int n) {
        // 幸运数的个数
        int luckNumCount = n / 2;

        double avg = money / n;
        double currentSum = 0d;
        Random random = new Random();
        for(int i = 0; i < n - 1; i++) {
            double currentMoney = 0;
            int offsetMoney = random.nextInt(offset);
            // 偶数加偏移的量
            boolean isAdd = i % 2 == 0;
            if (isAdd) {
                currentMoney = avg + offsetMoney - i;
            } else {
                // 奇数减偏移的量
                currentMoney = avg - offsetMoney;
            }

            if(luckNumCount > 0) {
                currentMoney = getCurrentRedPackageMoney(currentMoney, offset, isAdd);
                luckNumCount--;
            }
            System.out.println("当前用户" + i + "获得" + currentMoney +"元");
            currentSum += currentMoney;
        }

        double lastRedPackageMoney = money - currentSum;
        System.out.println("当前用户获得" + lastRedPackageMoney +"元");

    }

    private static double getCurrentRedPackageMoney(double currentMoney, int offset, boolean isAdd) {
        for (double luckMoney : luckNumList) {
            if (isAdd && currentMoney - luckMoney > offset) {
                return luckMoney;
            }
            if (!isAdd && luckMoney -  currentMoney < offset) {
                return luckMoney;
            }
        }
        return currentMoney;
    }

}