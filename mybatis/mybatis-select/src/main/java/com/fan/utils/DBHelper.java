package com.fan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author y
 */
public class DBHelper {
    public static SqlSession sqlSession;
    public static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader re = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开数据库连接
     */
    public static SqlSession openDB() {
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession(true);
        }
        return sqlSession;
    }

    /**
     * 关闭连接
     */
    public static void closeDB() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
