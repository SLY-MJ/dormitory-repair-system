package week01.project.mapper;

import week01.project.pojo.User;

public interface UserMapper {
    User selectById(String id);

    void insertUser(String id, String password, String name, String role);

    void deleteById(String id);


}
