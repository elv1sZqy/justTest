package com.tsu.zqy.redisAndMybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName GetSessionUtil
 * @Author Elv1s
 * @Date 2019/5/20 8:51
 * @Description:
 *                  用于得到session
 */
public class SessionUtil {

    public static SqlSession getSession() throws IOException {
        String resource = "mybatis-config.xml.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }



}
