package com.tsu.zqy.leetCode.yiqian;

/**
 * @author zhuQiYun
 * @create 2021/9/7
 * @description :
 */
public class Test_1221 {

    public int balancedStringSplit(String s) {
        int currentLCount = 0;
        int currentRCount = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                currentLCount++;
                if (currentLCount == currentRCount) {
                    max++;
                    currentRCount = 0;
                    currentLCount = 0;
                }
            }

            if (s.charAt(i) == 'R') {
                currentRCount++;
                if (currentLCount == currentRCount) {
                    max++;
                    currentRCount = 0;
                    currentLCount = 0;
                }
            }
        }

        return Math.max(1, max);
    }
}
