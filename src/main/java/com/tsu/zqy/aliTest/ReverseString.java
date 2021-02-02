package com.tsu.zqy.aliTest;

/**
 * @ClassName ReverseString
 * @Author Elv1s
 * @Date 2021/2/2 22:47
 * @Description:
 */
public class ReverseString {
    // 字符串反转
    // 要求:
    // 1. 实现一个函数 reverse, 输入参数为一个字符串, 返回结果为反转之后的字符串。
    // 2. 特殊处理, 字符串中出现单词 ali (连续字符) 时, 该单词需要保留顺序。
    // 3. 代码尽量健壮、清晰易懂，包含适当的注释，注释可使用中文。
    // 4. 编写完整可运行的程序，包含测试示例验证，确保本地测试运行通过。
    // 示例:
    // "welcome to alibaba!" -> "!ABABali OT EMOCLEW"
    // 这个有点问题...
    // "ali all in, Ali ilA" -> "aLI ILa ,NI LLA ali"
    // "keep ali" -> "ali PEEK"

    public static void main(String[] args) {
        System.out.println(reverse("ali all in, Ali ilA"));
    }

    private static String specialWord = "ali";

    /**
     * 1. 关键字为"ali"
     * 2. 不仅要互换位置, 还要改变大小写
     *
     * @param str
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int length = str.length();
        int right = length - 1;
        for (int left = 0; left < length; left++) {
            // 两个指针相遇,就结束
            if (left > right) {
                break;
            }
           /* // 特殊单词的处理
            char[] backup = chars;
            if (isSpecialWord(left, right, backup)) {
                chars = backup;
                int n = specialWord.length();
                left += n;
                right -= n;
                continue;
            }
*/
            // 一般单词就双指针替换
            char leftChar = chars[left];
            leftChar = changeCase(leftChar);
            chars[left] = changeCase(chars[right]);
            chars[right] = leftChar;
            right--;
        }
        return String.valueOf(chars);
    }

    private static boolean isSpecialWord(int left, int right, char[] chars) {
        boolean leftIsSpecialWord = true;
        boolean rightIsSpecialWord = true;
        int length = specialWord.length();
        for (int i = 0; i < length; i++) {
            if (chars[left] != specialWord.indexOf(i)) {
                leftIsSpecialWord = false;
                break;
            }
            left++;
        }
        for (int i = length; i > 0; i--) {
            if (chars[right] != specialWord.indexOf(i)) {
                rightIsSpecialWord = false;
                break;
            }
            right--;
        }

        return rightIsSpecialWord || leftIsSpecialWord;
    }

    /**
     * 1. A + 32 = a  A = 65
     * 2. ' '  = 32
     *
     * @param achar
     * @return
     */
    private static char changeCase(char achar) {
        // 转小写
        if (achar >= 'A' && achar <= 'Z') {
            achar += 32;
            return achar;
        }
        // 转大写
        if (achar >= 'a' && achar <= 'z') {
            achar -= 32;
            return achar;
        }
        // 除字母外保持原状
        return achar;
    }

}
