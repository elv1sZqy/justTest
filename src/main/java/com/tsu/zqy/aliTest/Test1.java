package com.tsu.zqy.aliTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Test1
 * @Author Elv1s
 * @Date 2019/7/3 15:33
 * @Description:
 * 
 * 1. 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *    例 1:  coins = [1, 2, 5], amount = 12, result =3 (5 + 5 + 2 = 12)
 *    例 2:  coins = [2], amount = 3, result = -1
 *    说明:每种硬币的数量是无限的。
 */
public class Test1 {
    
    @Test
    public void test1(){
        int[] coins = {2,3,4,5};
        int amount = 12;
        func(coins, amount);
    }

    @Test
    public void test2(){
        int[] coins = {2,3,4,5};
        int amount = 1;
        func(coins, amount);
    }

    @Test
    public void test3(){
        int[] coins = {2,3,4,5};
        int amount = 100;
        //得到结果并且打印
        func(coins, amount);
    }

    /**
     * 得到结果并且打印
     * @param coins
     * @param amount
     */
    private static void func(int[] coins, int amount) {
        int count = getMincount(coins, amount);
        System.out.println(count);
    }

    private static int getMincount(int[] coins, int amount) {
        //特殊情况
        if (coins.length == 0 || amount <= 0){
            return -1;
        }

        //先将数组排序
        Arrays.sort(coins);

        //count用于计数
        int count = 0;

        //循环
        for (int i = coins.length - 1; i >= 0; i--) {
            //总金额整除由大变变小
            if (amount >= coins[i]){
                //temp表示当前面额可取的个数
                int temp = amount / coins[i];
                count += temp;
                amount %= coins[i];
            }
        }

        //如果没有任何一种硬币组合能组成总金额，返回 -1。
        if (amount != 0){
            return -1;
        }
        //返回凑成总金额所需的最少的硬币个数
        return count;
    }

}
