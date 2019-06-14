package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_58
 * @Author Elv1s
 * @Date 2019/6/13 19:45
 * @Description: 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_58 {
    public static void main(String[] args){
        String s = "a ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    /**
     * 从后向前找
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        if (s.equals(" ") || s.length() == 0){
            return 0;
        }
        else if (s.length() == 1){
            return 1;
        }

        boolean flag = false;
        int count = 0;

        for (int i = s.length() -1; i >= 0; i--) {
            char c = s.charAt(i);

            //最后几个都是 " "的情况
            if (c == 32 && !flag){
                continue;
            }
            //32 为 " "
            else if (32 != c){
                flag = true;
                count++;
            }
            else if (!s.contains(" ")){
                s.length();
            }
            else {
                return count;
            }
        }

        return count;
    }
}
