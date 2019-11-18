package com.tsu.zqy.leetCode.stepthree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_349 {
    public static void main(String[] args) {
        System.out.println(new Test_349().intersection(new int[]{9, 5, 4}, new int[]{9,4,9,8,4}));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Object o = new Object();
        List<Integer> list = new ArrayList<>();
        Map<Integer,Object> map1 = new HashMap<>();
        Map<Integer,Object> map2 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i,o);
        }
        for (int i : nums2) {
            map2.put(i,o);
        }
        if (map1.size() > map2.size()) {
            map2.forEach((integer, o1) ->{
                if (map1.containsKey(integer)) {
                    list.add(integer);
                }
            });
        }
        else {
            map1.forEach((integer, o1) ->{
                if (map2.containsKey(integer)) {
                    list.add(integer);
                }
            });
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
