package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_66
 * @Author Elv1s
 * @Date 2019/6/14 14:49
 * @Description: 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_66 {
    public static void main(String[] args) {
        int[] nums = {9,9,9};
        int[] ints = plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        //当前指针的位置
        int currenIndex = digits.length - 1;
        //临时值
        int temp = digits[currenIndex];

        if ((digits[currenIndex] + 1) < 10){
            digits[currenIndex]  += 1;
            return digits;
        }

        while (currenIndex >= 0 && (temp + 1) >= 10) {
            //满十进一
            digits[currenIndex] = 0;

            if (currenIndex -1 < 0){
                //进位不足了   就新建一个数组
                int[] ints = new int[digits.length + 1];
                //第一位一定是1
                ints[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    ints[i+1] = digits[i];
                }
                return ints;
            }
            else {
                temp = digits[currenIndex - 1];
                digits[currenIndex - 1] += 1;
                currenIndex--;
            }
        }

        return digits;
    }


    public static int[] plusOne1(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            stringBuilder.append(digits[i]);
        }

        String i = Integer.parseInt(stringBuilder.toString()) + 1 + "";

        int[] ints = new int[i.length()];

        for (int j = 0; j < ints.length; j++) {
            ints[j] = (int) Double.parseDouble(String.valueOf(i.charAt(j)));
        }

        return ints;
    }
}
