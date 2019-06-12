package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_12
 * @Author Elv1s
 * @Date 2019/6/12 19:40
 * @Description:
 * 12. 整数转罗马数字
 */
public class Test_12 {
    public static void main(String[] args){
        int num = 27;
        String s = intToRoman(num);
        System.out.println(s);
    }

    public static String intToRoman(int num) {

        //因为是单线程  所以不考虑 线程安全问题
        StringBuilder sb = new StringBuilder();
        //1981
        //几个特殊值 的数字
        int nums[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        //几个特殊值的字符串形式
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]){
                sb.append(strs[i]);
                num -= nums[i];
            }
        }
        return sb.toString();
    }

}
