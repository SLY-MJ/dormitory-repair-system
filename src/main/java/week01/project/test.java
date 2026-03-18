package week01.project;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import week01.project.mapper.UserMapper;
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
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User("321", "password321", "mj", "admin");
            mapper.insertUser(user);
            List<User> list = mapper.selectAll();
            for (User user1 : list) {
                System.out.println("User ID: " + user1.getId());
                System.out.println("User Name: " + user1.getName());
                System.out.println("User Role: " + user1.getRole());
            }
        }

    }
}
