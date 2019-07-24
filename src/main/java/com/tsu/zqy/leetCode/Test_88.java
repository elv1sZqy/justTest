package com.tsu.zqy.leetCode;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @ClassName Test_88
 * @Author Elv1s
 * @Date 2019/7/22 14:26
 * @Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_88 {
    public static void main(String[] args){
        int[] num1 ={2,0};
        int[] num2 ={1};
        new Test_88().merge(num1, 1, num2, 1);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }

    public  void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return ;
        }
        if (m == 0){
            swap(nums2, nums1);
            return;
        }
        // 新建一个数组, 用来存值, 排序
        int[] ints = new int[n + m];
        for (int i = ints.length - 1; i >= 0; i--) {
            if (m -1 == -1 && n != 0){
                for(int j = n-1; j >= 0; j--){
                    ints[j] = nums2[j];
                }
                swap(ints,nums1);
                return;
            }
            if (n -1 == -1 && m != 0){
                for(int j = m-1; j >= 0; j--){
                    ints[j] = nums1[j];
                }
                swap(ints,nums1);
                return ;
            }

            int a = nums1[m-1];
            int b = nums2[n-1];

            if (a > b){
                ints[i] = a;
                m--;
            }
            else {
                ints[i] = b;
                n--;
            }
        }
        this.swap(ints,nums1);
        return ;
    }

    public  void swap(int[] ints1, int[] ints2){
        for (int i = 0; i < ints1.length; i++) {
            ints2[i] = ints1[i];
        }
    }
}
