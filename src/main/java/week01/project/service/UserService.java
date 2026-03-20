package week01.project.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import week01.project.mapper.UserMapper;
import week01.project.pojo.User;

import java.io.Reader;
import java.util.List;

public class UserService {

    private static final SqlSessionFactory FACTORY = buildFactory();

    private static SqlSessionFactory buildFactory() {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            return new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            throw new RuntimeException("初始化SqlSessionFactory失败", e);
        }
    }

    protected static SqlSessionFactory getFactory() {
        return FACTORY;
    }

    public boolean login(User user) {
        String id = user.getId();
        String password = user.getPassword();

        User checkUser;
        try (SqlSession session = FACTORY.openSession(false)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            checkUser = userMapper.selectById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (checkUser == null) {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }

        return checkUser.getPassword().equals(password);
    }

    public boolean register(User user) {
        String id = user.getId();
        String password = user.getPassword();

        try (SqlSession session = FACTORY.openSession(false)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User existingUser = userMapper.selectById(id);
            if (existingUser != null) {
                throw new RuntimeException("User with ID " + id + " already exists.");
            }
            userMapper.insertUser(user);
            session.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean changePassword(User user){
        try (SqlSession session= FACTORY.openSession(false)){
            UserMapper userMapper=session.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            session.commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<User> getAllUsers(){
        try (SqlSession session= FACTORY.openSession(false)){
            UserMapper userMapper=session.getMapper(UserMapper.class);
            return userMapper.selectAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
