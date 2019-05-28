package com.tsu.zqy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Author Elv1s
 * @Date 2019/5/28 14:10
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.tsu.zqy.redisAndMybatis.*.**")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

