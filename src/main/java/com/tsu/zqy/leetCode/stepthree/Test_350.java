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
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_350 {
    public static void main(String[] args) {
        System.out.println(new Test_350().intersect(new int[]{1,1}, new int[]{1,2}));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i,map1.get(i) +1);
            }
            else {
                map1.put(i,1);
            }
        }
        for (int i : nums2) {
            if (map2.containsKey(i)) {
                map2.put(i,map2.get(i) +1);
            }
            else {
                map2.put(i,1);
            }
        }
        if (map1.size() > map2.size()) {
            map2.forEach((integer, o1) ->{
                if (map1.containsKey(integer)) {
                    Integer o2 = map1.get(integer);
                    int times = o1 > o2 ? o2 : o1;
                    for (int i = 0; i < times; i++) {
                        list.add(integer);
                    }
                }
            });
        }
        else {
            map1.forEach((integer, o1) ->{
                if (map2.containsKey(integer)) {
                    Integer o2 = map2.get(integer);
                    int times = o1 > o2 ? o2 : o1;
                    for (int i = 0; i < times; i++) {
                        list.add(integer);
                    }
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
