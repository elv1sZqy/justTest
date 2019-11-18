package com.tsu.zqy.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuQiYun
 * @create 2019/11/6
 * @description :
 */
public class ProxyFactory implements MethodInterceptor {

    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始");
        Object invoke = method.invoke(object, args);
        System.out.println("cglib代理结束");
        return invoke;
    }



}
