package com.offcn.util.myutil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    //初始化sqlSessionFactory
    static {
        try {
            String config = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSessionFactory
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    //获取sqlSession
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    //关闭资源
    public static void closeSqlSession(SqlSession sqlSession) {
        if (threadLocal.get() != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
