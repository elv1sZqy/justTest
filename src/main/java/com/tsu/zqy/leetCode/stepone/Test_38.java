package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_38
 * @Author Elv1s
 * @Date 2019/6/13 18:25
 * @Description: 38. 报数
 * <p>
 * 数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_38 {

    public static void main(String[] args) {
        String s = countAndSay(5);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();

        Integer count = 1;
        char temp = 1;
        String result = "1";
        for (int i = 1; i < n; i++) {
            char[] chars = result.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {
                    temp = chars[0];
                    if (j + 1 >= chars.length) {
                        sb.append(count).append(temp);
                    }
                } else if (temp == chars[j]) {
                    count++;
                    if (j + 1 >= chars.length) {
                        sb.append(count).append(temp);
                    }
                } else {
                    sb.append(count).append(temp);
                    temp = chars[j];
                    count = 1;
                    if (j + 1 >= chars.length) {
                        sb.append(count + "" + Integer.parseInt(String.valueOf(temp)));
                    }

                }
            }
            result = sb.toString();
            //重置
            sb = new StringBuilder();
            count = 1;
        }

        return result;
    }
}
