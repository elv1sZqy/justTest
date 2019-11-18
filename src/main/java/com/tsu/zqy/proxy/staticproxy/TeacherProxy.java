package com.tsu.zqy.proxy.staticproxy;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :
 */
public class TeacherProxy implements Teacher{

    private Teacher teacher;

    public TeacherProxy(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void teach() {
        System.out.println("静态代理开始");
        teacher.teach();
        System.out.println("静态代理结束");
    }

    @Override
    public String getName() {
        System.out.println("老师回答名字:");
        return teacher.getName();
    }
}
