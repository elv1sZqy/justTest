package com.tsu.zqy.leetCode.stepone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test_18
 * @Author Elv1s
 * @Date 2020/10/5 8:15
 * @Description: 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_18 {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] arr = {-1,-5,-5,-3,2,5,0,4};
        System.out.println(solution.fourSum(arr, -7));

    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;
            if (nums == null || length <= 3) {
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < length - 3; i++) {
                // 防止答案重复
                int num1 = nums[i];
                if (i - 1 >= 0 && num1 == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < length; j++) {
                    // 防止答案重复
                    int num2 = nums[j];
                    if (j - 1 >= i + 1 && nums[j - 1] == num2) {
                        continue;
                    }
                    int tar = target - num1 - num2;
                    int leftIndex = j + 1;
                    int rightIndex = length - 1;
                    while (leftIndex < rightIndex) {
                        int num3 = nums[leftIndex];
                        int num4 = nums[rightIndex];
                        int sum = num3 + num4;
                        if (sum == tar) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(num1);
                            list.add(num2);
                            list.add(num3);
                            list.add(num4);
                            result.add(list);
                            while (num3 == nums[++leftIndex] && num4 == nums[--rightIndex]) {
                                if (leftIndex + 1 > rightIndex || rightIndex - 1 < leftIndex) {
                                    break;
                                }
                            }
                            continue;
                        }
                        if (sum < tar) {
                            leftIndex++;
                        } else {
                            rightIndex--;
                        }
                    }
                }
            }
            return result;
        }
    }

}
