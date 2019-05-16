package com.tsu.zqy.reflect;

import java.lang.reflect.Constructor;

/**
 * @ClassName ReflectTest
 * @Author Elv1s
 * @Date 2019/5/4 9:56
 * @Description:
 */
public class ReflectTest1 {

    private String name = "Elv1s";
    private int age;

    public ReflectTest1(){
        System.out.println("无参构造执行");
    }

    public ReflectTest1(int age){
        this.age = age;
        System.out.println("一个参数构造执行");
    }


    public static void main(String[] args) throws Exception {
        //抛出异常
        Class<?> clazz = Class.forName("com.tsu.zqy.reflect.ReflectTest1");

        //方式一class.newInstance();

        ReflectTest1 re = (ReflectTest1) clazz.newInstance();
        System.out.println(re);

        System.out.println("------------华丽分割线---------------");

        //方式二 先得到构造方法再new实例

        Constructor<?>[] constructors = clazz.getConstructors();
        //构造方法的个数
        System.out.println("构造方法的个数: " + constructors.length);
        //无参构造newInstance
        ReflectTest1 re2 = (ReflectTest1) clazz.getConstructor().newInstance();
        System.out.println(re2);

        //有参构造newInstance
        Constructor<?> constructor = clazz.getConstructor(int.class);
        ReflectTest1 re3 = (ReflectTest1) constructor.newInstance(18);
        System.out.println(re3);

        /*
        无参构造执行
        ReflectTest{name='Elv1s', age=0}
        ------------华丽分割线---------------
        构造方法的个数: 2
        无参构造执行
        ReflectTest{name='Elv1s', age=0}
        一个参数构造执行
        ReflectTest{name='Elv1s', age=18}
         */
    }

    @Override
    public String toString() {
        return "ReflectTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
