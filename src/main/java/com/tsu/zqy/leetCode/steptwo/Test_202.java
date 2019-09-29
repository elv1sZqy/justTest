package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;

/**
 * @author zhuQiYun
 * @create 2019/9/21
 * @description :
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 *
 * 2是平方
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_202 {
    public static void main(String[] args) {
        new Test_202().isHappy(19);
    }

    /**
     * 思路: 用一个map
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        char[] chars = (n + "").toCharArray();
        Object o = new Object();
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(n,o);
        boolean isNotHappy = true;
        int sum = 0;
        while (isNotHappy){
            for (char aChar : chars) {
                int num = Integer.parseInt(String.valueOf(aChar));
                sum += (num * num);
            }
            if (sum == 1){
                return true;
            }
            else {
                if (map.containsKey(sum)){
                    return false;
                }
                map.put(sum, o);
                chars = (sum + "").toCharArray();
                sum = 0;
            }

        }


        return true;
    }
}
