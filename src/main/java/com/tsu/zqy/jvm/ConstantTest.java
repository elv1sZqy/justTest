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
        System.out.println(Son.str);

        /*
        static final String str = "hello world ";时
        hello world
        因为加了final， str值在连接中的准备阶段就已经被付好了值


        Father没有被初始化
        */
        //System.out.println(Son.str);

        /*
         父类静态代码块执行...
         子类静态代码块执行...
         ni hao  shi jie
          子类初始化，父类必定需要初始化
         */
        //System.out.println(Son.str2);

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
    static  String str = "test 1 ";

    static {
        System.out.println(" 子类静态代码块执行...");
    }


}