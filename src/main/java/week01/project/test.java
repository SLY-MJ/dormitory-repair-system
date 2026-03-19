package week01.project;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import week01.project.mapper.StudentMapper;
import week01.project.mapper.UserMapper;
import week01.project.pojo.Student;
import week01.project.pojo.User;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        try (SqlSession session = factory.openSession(true)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = new Student("3125004023", "mjy2006113", "mj", "student","西一","611");
            Student student1 = new Student("3125004022", "ljysbsbsb", "Aurxs", "student","西一","603");
            mapper.insertUser(student);
            mapper.insertUser(student1);
            mapper.insertStudent(student);
            mapper.insertStudent(student1);
            List<Student> list = mapper.selectAllStudents();
            for (Student user1 : list) {
                System.out.println("User ID: " + user1.getId());
                System.out.println("User Name: " + user1.getName());
                System.out.println("User Role: " + user1.getRole());
                System.out.println("Building No: " + user1.getBuildingNo());
                System.out.println("Room No: " + user1.getRoomNo());
            }
        }
    }
}
