package com.tsu.zqy.spring.bean;

import com.tsu.zqy.spring.annotation.MyAnnotation;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName Tercher
 * @Author Elv1s
 * @Date 2020/9/12 21:54
 * @Description:
 */
@MyAnnotation(name = "teacher1")
@Primary
public class Teacher extends Person{
    private String address;
}
