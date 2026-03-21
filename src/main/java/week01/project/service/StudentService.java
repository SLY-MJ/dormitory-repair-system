package week01.project.service;

import org.apache.ibatis.session.SqlSession;
import week01.project.mapper.RepairMapper;
import week01.project.mapper.StudentMapper;
import week01.project.pojo.Repair;
import week01.project.pojo.Student;

public class StudentService extends UserService {
    public boolean registerDormitory(Student student) {
        try (SqlSession session = getFactory().openSession(false)) {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student existingStudent = studentMapper.selectStudentById(student.getId());
            if (existingStudent != null) {
                throw new RuntimeException("Student with ID " + student.getId() + " already exists.");
            }
            studentMapper.insertStudent(student);
            session.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public boolean addRepair(Repair repair) {
        try (SqlSession session = getFactory().openSession(false)) {
            RepairMapper mapper = session.getMapper(RepairMapper.class);
            mapper.insertRepair(repair);
            session.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public Student selectStudent(String id) {
        try (SqlSession session = getFactory().openSession(false)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectStudentDetailById(id);
            if (student == null) {
                throw new RuntimeException("Student with ID " + id + " does not exist.");
            }
            return student;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
