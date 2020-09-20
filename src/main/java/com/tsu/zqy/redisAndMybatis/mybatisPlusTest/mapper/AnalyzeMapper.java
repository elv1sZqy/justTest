package com.tsu.zqy.redisAndMybatis.mybatisPlusTest.mapper;

import com.tsu.zqy.redisAndMybatis.pojo.Analyze;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName AnalyzeMapper
 * @Author Elv1s
 * @Date 2020/2/7 14:59
 * @Description:
 */
@Mapper
public interface AnalyzeMapper {

    int insertAll(List<Analyze> list);
    List<Analyze> sea();

}
