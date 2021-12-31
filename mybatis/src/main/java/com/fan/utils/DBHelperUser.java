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
public class DBHelperUser {
    public SqlSession sqlSession;
    static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //读取配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config-user.xml");
            //创建mybatis核心对象slqSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 打开数据库连接
     * @return
     */
    public SqlSession openDB() {
        if (sqlSession == null) {
            //获取SqlSession(不带参数<代表事务手动提交>，openSession(true)代表事务自动提交)
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    /**
     * 关闭连接
     */
    public void closeDB() {
        if (sqlSession != null) {
            sqlSession.close();
        }

    }
}
