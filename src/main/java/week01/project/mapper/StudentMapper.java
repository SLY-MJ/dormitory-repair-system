package week01.project.mapper;

import org.apache.ibatis.annotations.Param;
import week01.project.pojo.Student;

public interface StudentMapper extends UserMapper {
    void insertStudent (Student student);

    void deleteStudentById(String id);

    Student selectStudentById(String id);

    void updateStudentId(@Param("oldId") String oldId, @Param("newId") String newId);

    void updateStudent(Student student);

}
