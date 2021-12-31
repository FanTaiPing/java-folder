package com.fan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author y
 */
public class ThreadLocalHelper {
    public static SqlSessionFactory sqlSessionFactory;
    public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    static {
        try {
            Reader re = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开数据库连接
     *
     * @return
     */
    public static SqlSession openDB() {
        try {
            if (threadLocal.get() == null) {
                threadLocal.set(sqlSessionFactory.openSession());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return threadLocal.get();
    }

    /**
     * 关闭数据库
     */
    public static void closeDB() {
        try {
            if (threadLocal.get() != null) {
                threadLocal.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务提交
     */
    public static void commit() {
        threadLocal.get().commit();
    }

    /**
     * 事务回滚
     */
    public static void rollback() {
        threadLocal.get().rollback();
    }
}
