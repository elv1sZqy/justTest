package com.tsu.zqy.reflect;

import java.lang.reflect.Field;

/**
 * @ClassName ReflectTest2
 * @Author Elv1s
 * @Date 2019/5/4 11:26
 * @Description:
 */
public class ReflectTestField {
    private String name;
    public int age;

    public ReflectTestField() { }

    public ReflectTestField(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        ReflectTestField reflectTestField = new ReflectTestField();
        Class<? extends ReflectTestField> clazz = reflectTestField.getClass();

        //属性需要public
        Field[] fields = clazz.getFields();
        System.out.println(fields.length);

        // getField()只能获得public的属性
        Field age = clazz.getField("age");
        System.out.println(age);
        System.out.println(age.getType());
        System.out.println(age.getName());

        System.out.println("--------------华丽分割线---------------");

        System.out.println(clazz.getDeclaredFields().length);
        //getDeclaredFields()可以获得所有属性
        Field name = clazz.getDeclaredField("name");
        System.out.println(name);
    }

    /*
    1
    public int com.tsu.zqy.reflect.ReflectTestField.age
    int
    age
    --------------华丽分割线---------------
    2
    private java.lang.String com.tsu.zqy.reflect.ReflectTestField.name
     */
}
