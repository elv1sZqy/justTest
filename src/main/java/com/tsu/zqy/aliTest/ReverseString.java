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
    // "ali all in, Ali ilA ali" -> "ali ALI ILA ,NI LLA ali"
    // "keep ali" -> "ali PEEK"

    public static void main(String[] args) {
        System.out.println(reverse("ali all in, ali Ali ilA ali iiiiii"));
    }

    private static String specialWord = "ali";

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (isSpecialWord(i, chars)) {
                replaceSpecialWord(sb);
                i -= (specialWord.length() - 1);
                continue;
            }
            char aChar = chars[i];
            sb.append(changeCase(aChar));
        }
        return sb.toString();
    }

    /**
     * 在倒置的字符串中拼接上正序的特殊词
     *
     * @param sb
     */
    private static void replaceSpecialWord(StringBuilder sb) {
        sb.append(specialWord);
    }

    public static String getResult(String str) {
        String str2 = reverse2(str);
        String[] arr = str2.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + toUpper(arr[i]) + " ";
        }
        return result;
    }


    public static String reverse2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse2(str.substring(1)) + str.charAt(0);
    }

    public static String toUpper(String str) {
        if (str.contains("ila")) {
            return str.toUpperCase().replaceAll("ILA", "ali");
        }

        return str.toUpperCase();
    }


    /**
     * 判断未来的几个char能组成指定的特殊单词
     *
     * @param currentIndex
     * @param chars
     * @return
     */
    private static boolean isSpecialWord(int currentIndex, char[] chars) {
        char[] specialWordChars = specialWord.toCharArray();
        for (int i = specialWord.length(); i > 0; i--) {
            if (currentIndex < 0) {
                return false;
            }
            if (currentIndex < 0 || specialWordChars[i - 1] != chars[currentIndex]) {
                return false;
            }
            currentIndex--;
        }
        return true;
    }

    /**
     * 1. 关键字为"ali"
     * 2. 不仅要互换位置
     *
     * @param str
     * @return 反转后的字符串
     */
    public static String reverse1(String str) {
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

    /*private static boolean isSpecialWord(int left, int right, char[] chars) {
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
    }*/

    /**
     * 1. A + 32 = a  A = 65
     * 2. ' '  = 32
     *
     * @param achar
     * @return
     */
    private static char changeCase(char achar) {
/*        // 转小写
        if (achar >= 'A' && achar <= 'Z') {
            achar += 32;
            return achar;
        }*/
        // 转大写
        if (achar >= 'a' && achar <= 'z') {
            achar -= 32;
            return achar;
        }
        // 除字母外保持原状
        return achar;
    }

}
