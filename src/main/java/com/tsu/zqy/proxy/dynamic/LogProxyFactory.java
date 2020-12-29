package com.tsu.zqy.proxy.dynamic;

import com.tsu.zqy.proxy.dynamic.impl.SayHi;

import java.lang.reflect.Proxy;

/**
 * @author zhuQiYun
 * @create 2020/11/16
 * @description :
 */
public class LogProxyFactory {
    public static void main(String[] args) {
        String name = "tom";
        SayHi sayHi = new SayHi(name);
        Say o = (Say) Proxy.newProxyInstance(SayHi.class.getClassLoader(), SayHi.class.getInterfaces(), (proxy, method, args1) -> {
            System.out.println("------");
            System.out.println(method.getName());
            Object invoke = method.invoke(sayHi, args1);
            System.out.println("------");
            return invoke;
        });
        o.say();
        System.out.println(o.callBack("one people"));
    }
}
