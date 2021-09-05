package com.tsu.zqy.leetCode.stepone;

import java.util.*;

/**
 * @ClassName Test_125
 * @Author zhuQiYun
 * @Date 2019/8/19 9:03
 * @Description:给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * <p>
 * 思路:   题中说只考虑数字和字母, 则需要将标点符号和空格进行处理
 * <p>
 * 然后将一半放入队列, 和另一半进行对比
 */
public class Test_125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Test_125().isPalindrome(s));
    }

    public boolean isPalindrome1(String s) {
        // 1.将字符串进行处理
        char[] chars = disposeStr(s);
      /*  // 2.计算长度是否是2的倍数
        if (chars.length % 2 != 0) {
            return false;
        }*/
        // 将一半放入队列
        int size = chars.length / 2;
        List<Character> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(chars[i]);
        }
        Iterator<Character> iterator = list.iterator();
        for (int i = chars.length - 1; i >= size; i--) {
            char aChar = chars[i];
            Character next = null;
            if (iterator.hasNext()) {
                next = iterator.next();
            }
            // 存在  clc  这种情况, 此时集合的最后一个为null 数组中有值
            if (next == null) {
                return true;
            }
            if (next != aChar) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        char[] chars = disposeStr(s);
        int size = chars.length / 2;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            queue.add(chars[i]);
        }

        int i = chars.length - 1;
        while (!queue.isEmpty() && i >= size) {
            Character poll = queue.poll();
            if (!poll.equals(chars[i])) {
                return false;
            }
            i--;
        }
        return true;
    }

    private char[] disposeStr(String s) {
        // 去除所有空格, 标点
        s = s.toLowerCase();
        String regex1 = "[^a-z0-9]";
        String result = s.replaceAll(regex1, "");

        return result.toCharArray();
    }
}
