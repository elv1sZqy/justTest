package com.tsu.zqy.spring;

import com.tsu.zqy.spring.annotation.MyAnnotation;
import com.tsu.zqy.spring.bean.Person;
import com.tsu.zqy.spring.bean.Teacher;
import com.tsu.zqy.spring.config.AppConfig;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @ClassName Test
 * @Author Elv1s
 * @Date 2020/2/15 12:17
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Teacher object = getBeanByAnnotation(annotationConfigApplicationContext, Teacher.class, "teacher");
        object.sayHi();
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        bean.sayHi();
    }

    private static <T> T getBeanByAnnotation(AnnotationConfigApplicationContext annotationConfigApplicationContext, Class T, String name) {
        if (annotationConfigApplicationContext instanceof ListableBeanFactory) {
            Map<String, Object> beansWithAnnotation = ((ListableBeanFactory) annotationConfigApplicationContext).getBeansWithAnnotation(MyAnnotation.class);
            T o = (T) beansWithAnnotation.get(name);
            return o;
        }
        return null;
    }

}
