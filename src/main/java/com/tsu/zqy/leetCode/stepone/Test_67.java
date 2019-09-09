package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_67
 * @Author Elv1s
 * @Date 2019/6/14 16:30
 * @Description: 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class Test_67 {
    public static void main(String[] args) {
        String s = addBinary("110010", "10111");
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();

        //切割数字
        String[] split = a.split("");
        Integer[] nums = new Integer[split.length];

        String[] split2 = b.split("");
        Integer[] nums2 = new Integer[split2.length];

        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        for (int i = 0; i < split2.length; i++) {
            nums2[i] = Integer.parseInt(split2[i]);
        }

        //确定长短数组
        Integer[] longArray;
        Integer[] shortArray;
        if (length1 > length2) {
            longArray = nums;
            shortArray = nums2;
        } else {
            longArray = nums2;
            shortArray = nums;
        }

        StringBuilder sb = new StringBuilder();

        int carry = 0;

        int cha = longArray.length - shortArray.length;

        int temp ;
        // 111 10
        for (int i = shortArray.length - 1; i >= 0; i--) {
            //相加
            if ((carry + shortArray[i] + longArray[cha + i]) >= 2) {
                temp = longArray[cha + i];
                longArray[cha + i] = (carry + shortArray[i] + longArray[cha + i]) % 2;

                if (temp + shortArray[i] + carry >= 2) {
                    carry = 1;
                } else {
                    carry = 0;
                }

                if (length1 == length2 && i - 1 == -1 && carry == 1) {
                    sb.append(1);
                }
            } else {
                temp = longArray[cha + i];
                longArray[cha + i] = (carry + shortArray[i] + longArray[cha + i]) % 2;
                if ((carry + shortArray[i] + temp) >= 2){
                    carry = 1;
                }
                else {
                    carry = 0;
                }
            }
        }

        if (carry == 1) {
            for (int j = longArray.length - shortArray.length - 1; j >= 0; j--) {
                if (longArray[j] == 1) {
                    longArray[j] = 0;
                    if (j == 0) {
                        sb.append(1);
                    }
                } else {
                    longArray[j] = 1;
                    break;
                }
            }
        }

        for (int i1 = 0; i1 < longArray.length; i1++) {
            sb.append(longArray[i1]);
        }

        return sb.toString();
    }

}
