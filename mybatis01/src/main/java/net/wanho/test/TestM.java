package net.wanho.test;

import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by rs on 2019/6/5.
 */
public class TestM {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(null, "张大飞", 15, "男", "洛阳");
        studentMapper.addStudent(student);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    @Test
    public void testAddStudent2() {
        Student student = new Student(null, "张二飞", 15, "男", "俄罗斯");
        studentMapper.addStudent2(student);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    @Test
    public void testDelStudent() {
        studentMapper.delStudent(21);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student(3, "李清照", 23, "女", "长安");
        studentMapper.updateStudent(student);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testEditStudent() {
        Student student = new Student(3, "李圆圆", 23, "女", "镐京");
        studentMapper.editStudent(student,3);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testGetAllStudent() {
        List<Student> allStudent = studentMapper.getAllStudent();
        System.out.println(allStudent);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testGetStudentById() {
        Student studentById = studentMapper.getStudentById(4);
        System.out.println(studentById);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testGetStudentByName() {
        List<Student> byName = studentMapper.getStudentByName("茂");
        System.out.println(byName);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
}
