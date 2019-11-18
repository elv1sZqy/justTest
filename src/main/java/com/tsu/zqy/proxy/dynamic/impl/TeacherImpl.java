package com.tsu.zqy.proxy.dynamic.impl;

import com.tsu.zqy.proxy.dynamic.Teacher;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :
 */
public class TeacherImpl implements Teacher {
    @Override
    public void teach() {
        System.out.println("老师上课....");
    }

    @Override
    public String getName() {
        return "Tom老师";
    }
}
