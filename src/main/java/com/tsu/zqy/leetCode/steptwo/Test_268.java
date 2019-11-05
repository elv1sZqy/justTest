package com.tsu.zqy.leetCode.steptwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/11/4
 * @description :给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_268 {

    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(new Test_268().missingNumber(arr));
    }
    public int missingNumber(int[] nums) {
        List<String> list = new ArrayList(nums.length);
        for (int i = 0; i < nums.length+1; i++) {
            list.add(i + "");
        }
        for (int num : nums) {
            list.remove(num + "");
        }
        return Integer.parseInt(list.get(0));
    }

}
