package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_28
 * @Author Elv1s
 * @Date 2019/6/13 15:05
 * @Description: 28. 实现strStr()
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_28 {
    public static void main(String[] args){
        String haystack = "mississippi", needle = "issipi";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }
    public static int strStr(String haystack, String needle) {
        //特殊情况
        if (haystack.isEmpty() && needle.isEmpty()){
            return 0;
        }
        //空的情况
        else if (haystack.isEmpty()){
            return -1;
        }
        else if(needle.isEmpty()){
            return 0;
        }
        //这个情况....   长的不会包含needle
        else if (haystack.length() < needle.length()){
            return -1;
        }

        //正常情况
        char[] need = needle.toCharArray();
        char[] target = haystack.toCharArray();

        //用于跳出循环
        boolean flag = false;
        //needle的指针
        Integer index = 0;

        for (int i = 0; i < target.length;) {
            /*"hello",   "ll";*/
            while (target[i] == need[index]){
                for (index = 0; index < need.length; ) {
                    //防止角标越界
                    if (index + i >= target.length){
                        return -1;
                    }
                    //之后也是相等的
                    else if (need[index] == target[index+i]){
                        flag = false;
                        index++;
                        if (index >= need.length) {
                            return i;
                        }
                    }
                    //不相等了
                    else {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
            //重置index
            index = 0;
            i++;
        }


        return -1;
    }
}
