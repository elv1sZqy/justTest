package com.tsu.zqy.leetCode.steptwo;

/**
 * @author zhuQiYun
 * @create 2019/9/12
 * @description :
 */
public class Test_191 {

    public static void main(String[] args) {
        new Test_191().hammingWeight(1011);
    }
    /**
     * 思路: 1.数字转成字符串再转成字符数组
     *       2. 遍历...  是1  就count ++;
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        char[] arr = (n + "").toCharArray();
        for (char c : arr) {
            if (c == '1'){
                count++;
            }
        }

        return count;
    }
}
