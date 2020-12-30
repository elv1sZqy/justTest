package com.tsu.zqy.leetCode.stepSeven;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhuQiYun
 * @create 2020/12/28
 * @description :
 * 给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * 说明: N是在[0, 10^9]范围内的一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_738 {
    public static void main(String[] args) {
        Test_738 test_738 = new Test_738();
        System.out.println(test_738.monotoneIncreasingDigits(3327853));
    }

    /**
     * 贪心算法
     *
     * @param N 以98为例,  如果num[i-1] > num[i]   num[i-1]需要减一, num[i]改为9 ---> 89
     *          以此类推, 局部解到全局解
     *          用一个flag记录, 从那一位开始后面全是9
     *
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        String[] nums = ("" + N).split("");
        int flag = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            int num = getNum(nums, i - 1);
            if (getNum(nums, i) < num) {
                nums[i - 1] = num - 1 + "";
                flag = i;
            }
        }
        for (int i = flag; i < nums.length; i++) {
            nums[i] = "9";
        }
        return stringArrayToInteger(nums);
    }

    private int stringArrayToInteger(String[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    private int getNum(String[] nums, int i) {
        return Integer.parseInt(nums[i]);
    }


    /**
     * 暴力法
     * 遍历小于等于当前的数, 然后判断这个数是不是递增的
     *
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits1(int N) {
        for (int n = N; n > 0; n--) {
            if (isIncreas(n)) {
                return n;
            }
        }
        return 1;
    }

    private boolean isIncreas(int n) {
        int max = 10;
        while (n > 0) {
            int value = n % 10;
            if (value > max) {
                return false;
            }
            max = value;
            n = n / 10;
        }
        return true;
    }
}
