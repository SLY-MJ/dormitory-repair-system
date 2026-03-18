package week01.project.mapper;

import org.apache.ibatis.annotations.Param;
import week01.project.pojo.User;

import java.util.List;

public interface UserMapper {
    User selectById(String id);

    List<User> selectAll();

    List<User> selectByRole(String role);

    void insertUser(User user);

    void deleteById(String id);

    void updateUser(User user);

    //双参数需要加@Param()才能使MyBatis正确识别参数或者放入map中整体传入
    void updateId(@Param("oldId") String oldId, @Param("newId") String newId);
}
