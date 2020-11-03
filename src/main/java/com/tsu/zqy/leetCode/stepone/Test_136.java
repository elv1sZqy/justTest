package com.tsu.zqy.leetCode.stepone;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Test_136
 * @Author zhuQiYun
 * @Date 2019/8/19 10:56
 * @Description:
 */
public class Test_136 {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -2};
        System.out.println(new Test_136().singleNumber(arr));
    }

    private int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        Integer[] integers = set.toArray(new Integer[0]);
        return integers[0];
    }

    /**
     * 异或
     * 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
     * 一个数和其本身做 XOR 运算等于 0：a⊕a = 0
     * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int singleNumber1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j && j != nums.length - 1) {
                    continue;
                }
                // 如果存在相似的, 就跳出当前循环
                if (i != j && nums[i] == nums[j]) {
                    break;
                }
                // 到最后都没找到第二个, 就返回值
                if (j == nums.length - 1) {
                    return nums[i];
                }

            }
        }
        return 1;
    }
}
