package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_69
 * @Author Elv1s
 * @Date 2019/6/15 14:21
 * @Description: 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_69 {

    public static void main(String[] args){
        int num  = 2147483647;
        int i = mySqrt(num);
        System.out.println(i);
    }

    public static int  mySqrt(int x) {
        if (x==0){
            return 0;
        }
        long sum = 0;
        long result = 1;
        while((sum + result)*(sum + result) <= x){
            if ((2*result + sum)*(2*result + sum)>Integer.MAX_VALUE
                    || (2*result + sum)*(2*result + sum)>x){
                sum = sum + result;
                result = 1;
            }else{
                result = 2*result;
            }
        }
        return (int)sum;
    }

    /*public static int mySqrt(int x) {

        int result = 1;

        while ((result * result) < x){
            result++;
        }
        if (result * result == x){
            return result;
        }
        else{
            return result-1;
        }

    }*/


}
