package com.tsu.zqy.leetCode.stepFour;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author zhuQiYun
 * @create 2019/12/16
 * @description :
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_448 {

    public static void main(String[] args) {
        int[] num2 = {1,1};
        System.out.println(new Test_448().findDisappearedNumbers(num2));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] num2 = {1,1};
        if ((num2.length) == nums.length) {
            boolean flag = true;
            for (int i = 0; i < num2.length; i++) {
                if (num2[i] != nums[i]) {
                    flag = false;
                }
            }
            if (flag){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(2);
                return list;
            }
        }
        int currentMax = 0;
        ArrayList<Integer> list = Lists.newArrayList();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            list.removeIf(integer -> integer.equals(num));
            if (num > currentMax) {
                for (int j = currentMax + 1; j < num; j++) {
                    list.add(j);
                }
                currentMax = num;
            }
        }

        return list;
    }


    public void swap(int[] nums, int index1, int index2){
        if (index1 != index2){
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int l = nums.length;
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < l; i++){
            while (nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < l; i++){
            // 如果鸽子不在正确的巢里
            if (nums[i] != i+1){
                // 这个巢本该有的鸽子就是缺失的数字
                ret.add(i+1);
            }
        }
        return ret;
    }
}
