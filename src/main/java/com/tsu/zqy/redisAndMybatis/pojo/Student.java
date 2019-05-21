package com.tsu.zqy.redisAndMybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Author Elv1s
 * @Date 2019/5/20 9:07
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 5960284624222728918L;

    private int sid;
    private String name;
    private String password;
    private String dormNum;
    private String className;
    private String grade;
    private String email;
    private String telephone;
    private String gender;

}
