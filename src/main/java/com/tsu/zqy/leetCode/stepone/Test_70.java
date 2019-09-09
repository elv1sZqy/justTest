package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_70
 * @Author Elv1s
 * @Date 2019/6/15 14:34
 * @Description: 70. 爬楼梯
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Test_70 {
    public static void main(String[] args){
        int num = 1;
        System.out.println(climbStairs(num));
    }

    /**
     * 循环
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        if (n == 1){
            return nums[0];
        }
        nums[1] = 2;
        for(int i=2; i<n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n-1];
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static  int climbStairs2(int n) {
        //一个台阶  有一种方法
        if (n == 1){
            return 1;
        }
        //如果是两个台阶有两种方式
        else if(n == 2){
            return 2;
        }

        //大于三种就用递归
        return climbStairs2(n-1) + climbStairs2(n - 2);
    }


}
