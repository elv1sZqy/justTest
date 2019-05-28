package com.tsu.zqy.jvm;

/**
 * @ClassName ConstantTest
 * @Author Elv1s
 * @Date 2019/5/23 13:21
 * @Description:
 */
public class ConstantTest {

    public static void main(String[] args) {
        /*
         static String str = "hello world "; 时
         父类静态代码块执行...
          hello world
         */
        //System.out.println(Son.str);

        /*
        static final String str = "hello world ";时
        hello world

        Father没有被初始化
        */
        //System.out.println(Son.str);

        /*
         父类静态代码块执行...
         子类静态代码块执行...
         ni hao  shi jie
          父类初始化   子类也初始化
         */
        System.out.println(Son.str2);

    }

}

class Father {

    //static String str = "hello world ";
    static final String str = "hello world ";

    static {
        System.out.println(" 父类静态代码块执行...");
    }
}

class Son extends Father {

    static String str2 = "ni hao  shi jie ";

    static {
        System.out.println(" 子类静态代码块执行...");
    }


}