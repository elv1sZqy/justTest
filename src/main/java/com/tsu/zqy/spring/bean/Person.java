package com.tsu.zqy.spring.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName person
 * @Author Elv1s
 * @Date 2020/2/15 12:19
 * @Description:
 */
@Component
@Data
public class Person {
    private String name;
    private Integer age;

    public void sayHi() {
        System.out.println("hi");
    }

}
