package com.tsu.zqy.redisAndMybatis.test;

import com.alibaba.fastjson.JSON;
import com.tsu.zqy.redisAndMybatis.pojo.Student;
import com.tsu.zqy.redisAndMybatis.util.JedisUtil;
import com.tsu.zqy.redisAndMybatis.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @ClassName CacheTest
 * @Author Elv1s
 * @Date 2019/5/21 14:37
 * @Description: 用redis做缓存
 */
public class CacheTest {

    public static void main(String[] args) {
        Integer sid = 202000106;

        //获得sid对应学生
        Student studentById = getStudentById(sid);
        System.out.println(studentById);

        studentById.setPassword("111");
        //更新
        updateStudent(studentById);

        System.out.println(getStudentById(sid));

        //删除学生
        delStudent(studentById);

    }


    /**
     * 通过id查学生信息
     *
     * @param id
     * @return
     */
    public static Student getStudentById(Integer id) {
        Student stu = null;

        StringBuffer sb = new StringBuffer("Student_");
        String key = sb.append(id).toString();

        //先查看redis中是否有数据,如果有就不用查数据库,如果没有就查数据库
        Jedis jedis = JedisUtil.getJedis();

        //缓存中有数据的情况
        if (jedis.exists(key)) {

            //用于直观的表现走的是缓存
            System.err.println("走心....");

            String student = jedis.get(key);
            stu = JSON.parseObject(student, Student.class);

            //关闭连接
            jedis.close();
            //直接返回
            return stu;
        }
        //缓存中没有的情况
        //关闭资源
        try (SqlSession session = SessionUtil.getSession()) {
            //查数据库
            stu = session.selectOne("Student.getStudentByid", id);

            //将查出来的数据存到缓存
            jedis.set(key, JSON.toJSONString(stu));

            System.err.println("走肾.....");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stu;
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    public static void updateStudent(Student student) {
        //更新一定会用到redis
        Jedis jedis = JedisUtil.getJedis();
        String key = new StringBuffer("Student_").append(student.getSid()).toString();

        try (SqlSession session = SessionUtil.getSession()) {

            int update = session.update("Student.updateStudent", student);

            //需要自己手动提交    ---- 一开始一直不知道哪错了   突然想到是不是事务没提交
            session.commit();

            if (update == 1) {
                //查出更新后的  存入缓存 替换之前的
                Student s = session.selectOne("Student.getStudentByid", student.getSid());
                jedis.set(key, JSON.toJSONString(s));
                System.out.println("缓存更新了");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭资源
        jedis.close();
    }

    /**
     * 删除学生
     * @param student
     */
    public static void delStudent(Student student) {
        Jedis jedis = JedisUtil.getJedis();
        String key = new StringBuffer("Student_").append(student.getSid()).toString();

        try (SqlSession session = SessionUtil.getSession()) {

            int delete = session.delete("Student.delStudent", student);

            //删除成功
            if (1 == delete) {
                jedis.del(key);
                System.out.println("删除了缓存" + key);
            }

            //测试就不提交了
            //session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
