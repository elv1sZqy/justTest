package com.tsu.zqy.spring.test;

import com.tsu.zqy.spring.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuQiYun
 * @create 2020/8/25
 * @description :
 */
public class XMLSpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-config.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
