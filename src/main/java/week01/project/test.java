package week01.project;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import week01.project.mapper.UserMapper;
import week01.project.pojo.User;

import java.io.IOException;
import java.io.Reader;

public class test {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        try (SqlSession session = factory.openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User("123", "password123", "John Doe", "user");
            mapper.insertUser(user);
            User user1 = mapper.selectById("123");
            System.out.println("User ID: " + user1.getName());
        }

    }
}
