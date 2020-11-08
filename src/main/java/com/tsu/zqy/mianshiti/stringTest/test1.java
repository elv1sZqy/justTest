package com.tsu.zqy.mianshiti.stringTest;

/**
 * @ClassName test1
 * @Author Elv1s
 * @Date 2020/10/21 21:18
 * @Description:        字符串常量Java内部加载
 */
public class test1 {

    public static void main(String[] args){
        String str1 = new StringBuilder().append("my").append("_test").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1.intern() == str1);

        System.out.println();

        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2.intern() == str2);

        System.out.println();


        String str3 = new StringBuilder().append("Ja").append("va2").toString();
        System.out.println(str3);
        System.out.println(str3.intern());
        System.out.println(str3.intern() == str3);
    }

}
