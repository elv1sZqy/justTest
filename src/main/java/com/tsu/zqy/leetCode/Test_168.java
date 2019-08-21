package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_168
 * @Author zhuQiYun
 * @Date 2019/8/20 15:24
 * @Description: 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_168 {

    public static void main(String[] args) {
        System.out.println(new Test_168().convertToTitle(24568));
    }


    /**
     * 思路: 就是类似于26进制, 每个字母对应一个数字
     */
    private Integer mulriple = 26;

    public String convertToTitle2(int n) {
        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            int k = n % 26;
            if (k == 0) {
                n -= 26;
                k = 26;
            }

            char c = (char) ((k - 1) + (int) 'A');
            sb.insert(0, c);
            n = n / 26;
        }
        return sb.toString();
    }

    public String convertToTitle(int n) {

        StringBuffer sb = new StringBuffer();
        // 65 对应A
        String result;
        char c = 64;
        if (n < 27) {
            result = String.valueOf((char) (c + n));
            return result;
        }
       /* // 两个字母
        else if (n <= 702){
            // 第一个字母
            int p = n / 26;
            // 第二个字母
            int pp = n % 26;
            if (pp == 0){
                p--;
                pp = 26;
            }
            sb.append(((char)(c + p)));
            sb.append((char)(c + pp));
        }
        else {
            // 第一个字母
            int p = n / (26 * 26);
            // 第二个字母
            int pp = (n % (26 * 26)) / 26;
            // 第三个字母
            int ppp = (n % (26 * 26)) % 26;
            sb.append(((char)(c + p)));
            sb.append((char)(c + pp));
            sb.append((char)(c + ppp));
        }*/

        int size = 0;
        if (n < 703) {
            size = 2;
            mulriple = 676;
        } else if (18954 > n) {
            size = 3;
            mulriple = 18252;
        } else {
            size = 4;
            mulriple = 474552;
        }
        int temp = mulriple;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                int p = n / (mulriple / 26);
                if (n % 26 == 0) {
                    p--;
                }
                sb.append(((char) (c + p)));
            } else if (i == size - 1) {
                int q = 1;
                int ppp = (n % (mulriple / (int) Math.pow(q, 26))) % 26;
                if (ppp == 0) {
                    ppp = 26;
                }
                sb.append((char) (c + ppp));
            } else {
                temp = temp / 26;
                int pp = (n % (temp)) / 26;
                sb.append((char) (c + pp));
            }

        }

        return sb.toString();
    }


}
