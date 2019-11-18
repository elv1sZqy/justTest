package com.tsu.zqy.proxy.dynamic;

import com.tsu.zqy.proxy.dynamic.Teacher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :
 */
public class ProxyFactory{

    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object getProxyObject() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理....");
                        Object invoke = method.invoke(object, args);
                        System.out.println("动态代理....");
                        return invoke;
                    }
                });
    }



}
