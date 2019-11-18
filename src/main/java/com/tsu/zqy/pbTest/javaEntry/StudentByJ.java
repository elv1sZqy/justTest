package com.tsu.zqy.pbTest.javaEntry;

import java.io.Serializable;

/**
 * @author zhuQiYun
 * @create 2019/10/8
 * @description :
 */
public class StudentByJ implements Serializable {
    private int age;
    private int id;
    private int state;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentByJ{" +
                "age=" + age +
                ", id=" + id +
                ", state=" + state +
                ", name='" + name + '\'' +
                '}';
    }
}
