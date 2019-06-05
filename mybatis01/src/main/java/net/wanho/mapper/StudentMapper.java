package net.wanho.mapper;

import net.wanho.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    void addStudent(Student student);

    void addStudent2(Student student);

    void delStudent(@Param("id") Integer id);

    void updateStudent(Student student);

    void editStudent(@Param("stu") Student student,@Param("id") Integer id);

    List<Student> getAllStudent();

    Student getStudentById(Integer id);

    List<Student>  getStudentByName(String sanme);
}
