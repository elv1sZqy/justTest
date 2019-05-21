package com.tsu.zqy.redisAndMybatis.test;

import com.tsu.zqy.redisAndMybatis.pojo.Student;
import com.tsu.zqy.redisAndMybatis.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Author Elv1s
 * @Date 2019/5/20 9:12
 * @Description:
 */
public class MybatisTest {

    @Test
    public void test1(){
        try( SqlSession session = SessionUtil.getSession()) {

            //通过id查单个
            Student student = session.selectOne("Student.getStudentByid", 1);
            System.out.println(student);

            //查询所有student
            List<Student> students = session.selectList("Student.getStudents");
            System.out.println(students);

            //通过教师id查班级里的学生
            List<Student> studentList  = session.selectList("Student.getStudentsByTid",1);
            System.err.println(studentList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
