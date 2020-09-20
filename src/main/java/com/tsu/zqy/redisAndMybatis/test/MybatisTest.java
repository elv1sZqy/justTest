package com.tsu.zqy.redisAndMybatis.test;

import com.google.common.collect.Lists;
import com.tsu.zqy.poi.ExcelUtil;
import com.tsu.zqy.redisAndMybatis.mybatisPlusTest.mapper.AnalyzeMapper;
import com.tsu.zqy.redisAndMybatis.pojo.Analyze;
import com.tsu.zqy.redisAndMybatis.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Workbook;
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
/*
            //通过id查单个
            Student student = session.selectOne("Student.getStudentByid", 1);
            System.out.println(student);

            //查询所有student
            List<Student> students = session.selectList("Student.getStudents");
            System.out.println(students);

            //通过教师id查班级里的学生
            List<Student> studentList  = session.selectList("Student.getStudentsByTid",1);*/

            ExcelUtil excelTest = new ExcelUtil();
            System.out.println(">>>>>>开始读取数据");
            Workbook wb = excelTest.getExcel("C:\\Users\\NewB1\\Desktop\\所得税收入分析.xlsx");

            List<Analyze> analyzes = null;
            if (wb == null)
                System.out.println("文件读入出错");
            else {
                analyzes = excelTest.analyzeExcel(wb);
            }
            if (analyzes!=null) {
                System.out.println(">>>>>>>开始导入数据");
                AnalyzeMapper mapper = session.getMapper(AnalyzeMapper.class);
                List<List<Analyze>> partition = Lists.partition(analyzes, 2000);
                for (List<Analyze> analyzeList : partition) {
                    mapper.insertAll(analyzeList);
                }
                System.out.println(">>>>>>>数据导入完成,成功导入:" +analyzes.size()+"条数据");
            }
            session.commit();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
