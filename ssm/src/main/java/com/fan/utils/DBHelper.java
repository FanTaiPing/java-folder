package com.fan.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author y
 */
public class DBHelper {
    static SqlSessionFactory sqlSessionFactory;
    static SqlSession sqlSession;
    static {
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
    }
}
