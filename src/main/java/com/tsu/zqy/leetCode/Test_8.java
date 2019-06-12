package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_8
 * @Author Elv1s
 * @Date 2019/6/12 15:37
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Test_8 {
    public static void main(String[] args){
        int x  = 103301;
        boolean is = solution(x);
        System.out.println(is);
    }

    private static boolean solution(int x) {

        //特殊情况  (如果是负数,  就直接返回false)
        if (x < 0){
            return false;
        }

        //用Stringbuffer的倒置方法 取倒过来的数
        StringBuffer sb = new StringBuffer(x+"");
        int reSb = 0;

        try {
            reSb = Integer.parseInt(sb.reverse().toString());
        } catch (NumberFormatException e) {
            //溢出返回false
            return false;
        }

        if (reSb == x){
            return true;
        }
        else{
            return false;
        }
    }
}
