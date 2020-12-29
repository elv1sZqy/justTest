package com.tsu.zqy.leetCode.steptwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/12/15
 * @description :
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i == 0) {
                sb.append(num);
                continue;
            }

            int preNum = nums[i - 1];

            if (i == nums.length - 1) {
                if (num - preNum == 1) {
                    sb.append("->" + num);
                    result.add(sb.toString());
                } else {
                    if (sb.length() > 0) {
                        if (Integer.parseInt(sb.toString()) != preNum) {
                            sb.append("->" + preNum);
                        }
                        result.add(sb.toString());
                    }
                    result.add(num+"");
                }
                break;
            }

            if ((num - preNum != 1)) {
                if (Integer.parseInt(sb.toString()) != preNum) {
                    sb.append("->" + preNum);
                }
                result.add(sb.toString());
                sb = new StringBuilder().append(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        List<String> strings = Test_228.summaryRanges(nums);
        System.out.println(strings);
    }
}
