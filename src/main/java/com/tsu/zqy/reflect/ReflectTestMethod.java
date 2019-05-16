package com.tsu.zqy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectTestMethod
 * @Author Elv1s
 * @Date 2019/5/4 11:42
 * @Description:
 */
public class ReflectTestMethod {

    private void sayHi(){
        System.out.println("hello world");
    }
    public void sayHi(String name){
        System.out.println(name + ":  hello world");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<ReflectTestMethod> clazz = ReflectTestMethod.class;

        //getDeclaredMethod()可以获得所有
        Method sayHi = clazz.getDeclaredMethod("sayHi");
        sayHi.invoke(clazz.newInstance(),args);

        //getMethod()只能获得public的方法
        Method whoSay = clazz.getMethod("sayHi", String.class);
        whoSay.invoke(clazz.newInstance(), "tom");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method d  : declaredMethods) {
            System.out.println(d);
        }

        /*
            hello world
            tom:  hello world
            public static void com.tsu.zqy.reflect.ReflectTestMethod.main(java.lang.String[]) throws java.lang.NoSuchMethodException,java.lang.reflect.InvocationTargetException,java.lang.IllegalAccessException,java.lang.InstantiationException
            private void com.tsu.zqy.reflect.ReflectTestMethod.sayHi()
            public void com.tsu.zqy.reflect.ReflectTestMethod.sayHi(java.lang.String)
         */
    }

}
