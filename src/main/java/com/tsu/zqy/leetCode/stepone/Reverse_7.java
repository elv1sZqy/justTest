package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Reverse_7
 * @Author Elv1s
 * @Date 2019/6/12 14:46
 * @Description: 整数倒置
 */
public class Reverse_7 {

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    /**
     * !!!!溢出就返回0
     * @param x
     * @return
     */
    public static int reverse(int x) {
        //1.返回值
        int result = 0;

        //2.特殊情况  -9 到 9  返回值都是本身
        if (x <= 9 && x >= -9) {
            return x;
        }

        //3.正常情况

        char[] nums = (x + "").toCharArray();

        //3.1大于零的情况
        if (x > 0){
            //临时接受的数组
            char[] temp = new char[nums.length];
            for (int i = 0; i < nums.length; i++) {
                //倒置字符数组
                temp[temp.length - 1 - i] = nums[i];
            }
            try {
                result = Integer.parseInt(new String(temp));
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        //3.2小于零
        else {
            //因为负数多了一个符号
            char[] temp = new char[nums.length -1];
            for (int i = 0; i < nums.length - 1; i++) {
                //倒置字符数组
                temp[temp.length - 1 - i] = nums[i + 1];
            }
            try {
                result = -(Integer.parseInt(new String(temp)));
            } catch (NumberFormatException e) {
                return 0;
            }
        }
            return result;
    }

}
