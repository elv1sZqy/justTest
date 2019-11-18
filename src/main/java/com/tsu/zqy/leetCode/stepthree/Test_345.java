package com.tsu.zqy.leetCode.stepthree;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_345 {

    public static void main(String[] args) {
        System.out.println(new Test_345().reverseVowels("ai"));
    }

    public String reverseVowels(String s) {
        s = s.trim();
        if (s.length() == 1) {
            return s;
        }
        if (s.isEmpty()) {
            return s;
        }
        Map<Character, Object> map = new HashMap<>();
        Object o = new Object();
        char[] letter=new char[] {'a','e','i','o','u','A','E','I','O','U'};
        for (char c : letter) {
            map.put(c,o);
        }
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        Boolean leftFlag = true;
        int rightIndex = chars.length -1;
        Boolean rightFlag = true;
       while (true) {
           while (leftFlag) {
               if (map.containsKey(chars[leftIndex])) {
                   leftFlag = false;
               }else{
                   leftIndex++;
                   if (leftIndex >= rightIndex) {
                       return String.valueOf(chars);
                   }
               }
           }
           while (rightFlag) {
               if (map.containsKey(chars[rightIndex])) {
                   rightFlag = false;
               }else{
                   rightIndex--;
                   if (leftIndex >= rightIndex) {
                       return String.valueOf(chars);
                   }
               }
           }
           char temp = s.charAt(leftIndex);
           chars[leftIndex] = chars[rightIndex];
           chars[rightIndex] = temp;
           if (leftIndex + 1 == rightIndex) {
               return String.valueOf(chars);
           }
           leftIndex++;
           rightIndex--;
           rightFlag = true;
           leftFlag = true;
       }
    }

}
