package week01.project;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import week01.project.mapper.AdminMapper;
import week01.project.mapper.RepairMapper;
import week01.project.mapper.StudentMapper;
import week01.project.mapper.UserMapper;
import week01.project.pojo.Admin;
import week01.project.pojo.Repair;
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
            RepairMapper repairMapper = session.getMapper(RepairMapper.class);
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            AdminMapper adminMapper = session.getMapper(AdminMapper.class);
            Admin admin = new Admin("0025004123", "张三", "123456", "admin", 123456789);
            Repair repair = new Repair("3125004023","0025004123" ,"水龙头坏了", "未完成", "2026-3-20");
//            adminMapper.insertAdmin(admin);
//            repairMapper.insertRepair(repair);
//            repairMapper.deleteRepairById(1);
            adminMapper.insertUser(admin);
            List<Repair> repairs = repairMapper.selectAll();
            for (Repair r : repairs) {
                System.out.println("Repair ID: " + r.getId());
                System.out.println("Student ID: " + r.getStudentId());
                Student student = studentMapper.selectStudentDetailById(r.getStudentId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student BuildingNo: " + student.getBuildingNo());
                System.out.println("Student RoomNo: " + student.getRoomNo());
                System.out.println("Admin ID: " + r.getAdminId());
                Admin admin1 = adminMapper.selectAdminById(r.getAdminId());
                System.out.println("Admin Name: " + admin1.getName());
                System.out.println("Admin Phone: " + admin1.getPhone());
                System.out.println("Description: " + r.getDescription());
                System.out.println("Status: " + r.getStatus());
                System.out.println("Date: " + r.getDate());
            }
//            List<Student> list = studentMapper.selectAllStudents();
//            for (Student user1 : list) {
//                System.out.println("User ID: " + user1.getId());
//                System.out.println("User Name: " + user1.getName());
//                System.out.println("User Role: " + user1.getRole());
//                System.out.println("Building No: " + user1.getBuildingNo());
//                System.out.println("Room No: " + user1.getRoomNo());
//            }
        }
    }
}
