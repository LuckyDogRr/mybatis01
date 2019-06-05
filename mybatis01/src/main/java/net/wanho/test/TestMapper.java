package net.wanho.test;

import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMapper {

    private SqlSession sqlSession;
    private SqlSession session = MybatisUtil.getSession();

    @Before
    public void before() {
        InputStream inputStream = TestMapper.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(null, "曹操", 15, "男", "洛阳");
        sqlSession.update("net.wanho.mapper.StudentMapper.addStudent", student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelStudent() {
        sqlSession.delete("net.wanho.mapper.StudentMapper.delStudent", 12);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student(3, "李清照", 23, "女", "长安");
        sqlSession.update("net.wanho.mapper.StudentMapper.updateStudent", student);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testGetAllStudent() {
        List<Student> students = session.selectList("net.wanho.mapper.StudentMapper.getAllStudent");
        System.out.println(students);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    @Test
    public void testGetStudentById() {
        Student stu = session.selectOne("net.wanho.mapper.StudentMapper.getStudentById", 4);
        System.out.println(stu);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

}
