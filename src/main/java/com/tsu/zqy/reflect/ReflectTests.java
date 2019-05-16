package com.tsu.zqy.reflect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ReflectTests
 * @Author Elv1s
 * @Date 2019/5/4 11:24
 * @Description:
 */
public class ReflectTests {
    /**
     * 枚举A
     */
    enum A{
        B,C
    }

    @Test
    public void testReflect(){
        try {
            Class<?> clazz = Class.forName("com.tsu.zqy.reflect.ReflectTest1");
            //得到规范的名字(类全名)      com.tsu.zqy.reflect.ReflectTest1
            System.out.println(clazz.getCanonicalName());
            //获得类名(类全名)              com.tsu.zqy.reflect.ReflectTest1
            System.out.println(clazz.getName());
            //获得简单的类名       ReflectTest1
            System.out.println(clazz.getSimpleName());
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            //可能会抛出 ClassNotFoundException  找不到类异常
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        Class<ReflectTest1> clazz = ReflectTest1.class;
        // class com.tsu.zqy.reflect.ReflectTest1
        System.out.println(clazz);
        Class<Integer> intClazz = int.class;
        //  int
        System.out.println(intClazz);
        // class java.lang.Integer
        System.out.println(Integer.class);
        Class<String> stringClass = String.class;
        // class java.lang.String
        System.out.println(stringClass);
        // double
        System.out.println(double.class);
        //  char
        System.out.println(char.class);
    }

    @Test
    public void test3(){
        Class stringClazz = "str".getClass();
        System.out.println(stringClazz.getName());
        /*
        int 没有getClass方法
        int b = 1;
        b.getClass()
        */
        Integer a = 1;
        System.out.println(a.getClass().getName());
        ReflectTest1 re = new ReflectTest1();
        System.out.println(ReflectTests.A.B.getClass().getCanonicalName());
        System.out.println(ReflectTests.A.B.getClass().getName());

        /*
         * 结果
         * java.lang.String
         * java.lang.Integer
         * com.tsu.zqy.reflect.ReflectTests.A
         * com.tsu.zqy.reflect.ReflectTests$A
         */

    }

    @Test
    public void test4(){
        ArrayList<Object> list = Lists.newArrayList();
        System.out.println(list.getClass().getCanonicalName());

        //方式1
        if (list instanceof Set){
            System.out.println("list 是 Set的实例");
        }
        else if (list instanceof List){
            System.out.println("list 是 List的实例");
        }
        else{
            System.out.println("list不是 List的实例");
        }

        //方式2
        if (List.class.isInstance(list)){
            System.out.println("list 是 List的实例");
        }

        HashMultiset<Object> multiset = HashMultiset.create();
        System.out.println(multiset.getClass().getCanonicalName());
        if (multiset instanceof Multiset){
            System.out.println("multiset 是 Multiset的实例");
        }

        /*
        java.util.ArrayList
        list 是 List的实例
        list 是 List的实例
        com.google.common.collect.HashMultiset
        multiset 是 Multiset的实例
     */
    }

}
