package com.tsu.zqy.leetCode.babai;

import org.junit.Test;

/**
 * @author zhuQiYun
 * @create 2020/10/27
 * @description :我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_845 {
    @Test
    public void fun(){
        int[] ints = {9,8,7,6,5};
        System.out.println(Test_845.longestMountain(ints));
    }

    // 中间高两边低叫山脉
    public static int longestMountain(int[] A) {
        if (A.length <= 2) return 0;
        int preNodeValue = A[0];
        boolean findTop = false;
        int maxLength = 0;
        int currentLength = 0;
        for (int i : A) {
            if (!findTop) {
                if (i < preNodeValue) {
                    findTop = true;
                }
            } else {
                // 结束当前山脉
                if (preNodeValue < i) {
                    maxLength = Math.max(maxLength, currentLength);
                    findTop = false;
                    currentLength = 1;
                }
            }
            currentLength++;
            preNodeValue = i;
        }
        if (findTop) {
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
