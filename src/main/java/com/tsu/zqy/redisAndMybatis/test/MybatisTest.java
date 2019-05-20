package com.tsu.zqy.redisAndMybatis.test;

import com.tsu.zqy.redisAndMybatis.pojo.Student;
import com.tsu.zqy.redisAndMybatis.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName MybatisTest
 * @Author Elv1s
 * @Date 2019/5/20 9:12
 * @Description:
 */
public class MybatisTest {

    @Test
    public void test1(){
        try {
            SqlSession session = SessionUtil.getSession();

            Student student = session.selectOne("Student.getStudentByid", 1);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
