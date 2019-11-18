package com.tsu.zqy.proxy.cglib;

import com.tsu.zqy.proxy.cglib.impl.TeacherImpl;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :  被代理类和代理类实现同一个接口, 代理类依赖被代理类.
 */
public class client {

    public static void main(String[] args) {
        Teacher teacher = new TeacherImpl();
        Teacher proxyObject = (Teacher) new ProxyFactory(teacher).getProxyInstance();
        proxyObject.teach();
        System.out.println(proxyObject.getName());
    }
}
