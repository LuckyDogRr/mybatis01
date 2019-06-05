package net.wanho.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sf;

    private static ThreadLocal<SqlSession> threadLocal;
    static {
        threadLocal = new ThreadLocal<SqlSession>();
        InputStream inputStream = MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sf = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
//            sqlSession不存在，创建新的
            sqlSession= sf.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

//    关闭session
    public static void closeSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }








}
