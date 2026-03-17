package week01.project.mapper;

import week01.project.pojo.User;

public interface UserMapper {
    User selectById(String id);

    void insertUser(User user);

    void deleteById(String id);


}
