package com.tsu.zqy.redisAndMybatis.mybatisPlusTest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsu.zqy.redisAndMybatis.pojo.Student;

import java.util.List;

/**
 * @InterfaceName StudentMapper
 * @Author Elv1s
 * @Date 2019/5/28 14:17
 * @Description:
 */

public interface StudentMapper extends BaseMapper<Student> {

    Student getStudentByid(int sid);

    List<Student>  getStudents();

}
