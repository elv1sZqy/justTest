package com.tsu.zqy.leetCode.steptwo;

/**
 * @ClassName Test_171
 * @Author zhuQiYun
 * @Date 2019/8/22 9:24
 * @Description:
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 */
public class Test_171 {

    public static void main(String[] args){
        System.out.println(new Test_171().titleToNumber("ZY"));
    }

    /**
     * 26进制;
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        double result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            double pow =((int) chars[i] - 64) * Math.pow(26, chars.length - i - 1);
            result += pow;
        }

        return (int)result;
    }

}
