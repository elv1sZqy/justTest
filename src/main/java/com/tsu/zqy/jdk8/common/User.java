package com.tsu.zqy.jdk8.common;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName User
 * @Author Elv1s
 * @Date 2019/5/12 15:24
 * @Description:
 */
public class User {

    private String name;

    private Integer age;

    private String home;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    private static List<User> list = Arrays.asList(new User("tom",23),
             new User("jason",12),new User("jack",34)
            );

    public static List<User> getList() {
        return list;
    }

    public static void setList(List<User> list) {
        User.list = list;
    }

    public static void eat(String s){
        System.out.println("我可以吃" + s);
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", home='" + home + '\'' +
                '}';
    }
}
