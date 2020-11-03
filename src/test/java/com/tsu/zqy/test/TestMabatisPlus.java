package com.tsu.zqy.test;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tsu.zqy.redisAndMybatis.mybatisPlusTest.mapper.StudentMapper;
import com.tsu.zqy.redisAndMybatis.pojo.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName TestMabatisPlus
 * @Author Elv1s
 * @Date 2019/5/28 14:29
 * @Description:
 */
@SpringBootTest
public class TestMabatisPlus {

    @Autowired
    StudentMapper studentMapper;

        @Test
        public void testSelect() {
            //List<Student> studentList = studentMapper.selectList(null);
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            //只查询出 sid 和 name 列
            QueryWrapper<Student> select = studentQueryWrapper.select("sid","name");
            //转换成stream
            Stream<Student> stream = studentMapper.selectList(select).stream();
            //过滤出学号大于999的学生姓名
            List<String> studentList = stream.filter(student -> student.getSid() >999)
                    .map(Student::getName).collect(Collectors.toList());
            studentList.forEach(System.out::println);

            QueryWrapper<Student> select1 = studentQueryWrapper.select("*");
            List<Student> studentList1 = studentMapper.selectList(select1);
            //转成json
            System.out.println(JSON.toJSONString(studentList1));
        }


}
