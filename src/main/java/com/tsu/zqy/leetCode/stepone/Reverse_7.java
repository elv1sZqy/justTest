package com.tsu.zqy.leetCode.stepone;

import org.jetbrains.annotations.NotNull;

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

    public int reverse3(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE * 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // 取到最低位的值
            int currentNum = x % 10;
            x /= 10;
            result = 10 * result + currentNum;
        }
        return result;
    }

    public static int reverse(int x) {
        //1.返回值
        int result = 0;

        //2.特殊情况  -9 到 9  返回值都是本身
        if (x <= 9 && x >= -9) {
            return x;
        }
        if (x > 0) {
            String str = reverseString(Integer.toString(x));
            return integerValueOfString(str);
        }
        String str = reverseString(Integer.toString(x).substring(1));
        return -integerValueOfString(str);
    }

    @NotNull
    private static Integer integerValueOfString(String str) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char tempChar = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = tempChar;
        }
        return String.valueOf(chars);
    }

    /**
     * !!!!溢出就返回0
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        //1.返回值
        int result = 0;

        //2.特殊情况  -9 到 9  返回值都是本身
        if (x <= 9 && x >= -9) {
            return x;
        }

        //3.正常情况

        char[] nums = (x + "").toCharArray();

        //3.1大于零的情况
        if (x > 0) {
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
            char[] temp = new char[nums.length - 1];
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
