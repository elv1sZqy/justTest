package com.tsu.zqy.reflect;

import com.google.common.collect.Maps;
import com.tsu.zqy.jdk8.common.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName reflectMap
 * @Author Elv1s
 * @Date 2019/5/13 20:04
 * @Description:
 */
public class reflectMap {

    public static void main(String[] args) throws Exception {
        Map<Object, Object> map = Maps.newHashMap();
        map.put("name", "jason");
        map.put("age", 19);
        map.put("home", "zheJiang.NingBo");

        //User user = map2Object(map, User.class);
        User user = map2Object3(map,User.class);

        System.out.println(user);
    }

    private static <T> T map2Object3(Map<Object, Object> map, Class<T> clazz) throws Exception {
        if (map == null){
            return null;
        }

        T t = clazz.newInstance();
        //map的key
        for (Object o : map.keySet() ) {
            if (clazz.getDeclaredField(o.toString()) != null){
                //map的key对应的属性
                Field declaredField = clazz.getDeclaredField(o.toString());
                //设置可见性为true
                declaredField.setAccessible(true);
                //setters
                declaredField.set(t, map.get(o));
            }

        }

        return t;
    }

    private static <T> T map2Object(Map<Object, Object> map, Class<T> clazz) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        T t = clazz.newInstance();
        //拿到类的信息
        BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
        //属性描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor p : propertyDescriptors) {
            System.out.println(p);
            //参数
            Object o = map.get(p.getName());
            //set方法
            Method setter = p.getWriteMethod();

            //防止是class
            if (setter != null && o != null) {
                //执行方法
                setter.invoke(t, o);
            }
        }
        return t;
    }


    public static User map2Object2(Map<Object, Object> map, Class<User> clazz) throws Exception {
        User user = clazz.newInstance();

        Field home = clazz.getDeclaredField("home");
        home.setAccessible(true);
        home.set(user,"ningBo");

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "jason");

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(user, 22);

        return user;
    }




}
