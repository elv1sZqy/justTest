package com.tsu.zqy.redisAndMybatis.mybatisPlusTest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsu.zqy.redisAndMybatis.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName StudentMapper
 * @Author Elv1s
 * @Date 2019/5/28 14:17
 * @Description:
 */

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
