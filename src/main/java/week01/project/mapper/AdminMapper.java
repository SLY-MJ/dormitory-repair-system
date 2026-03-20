package week01.project.mapper;

import org.apache.ibatis.annotations.Param;
import week01.project.pojo.Admin;

import java.util.List;

public interface AdminMapper extends UserMapper {
    void insertAdmin(Admin admin);

    void deleteAdminById(String id);

    Admin selectAdminById(String id);

    List<Admin> selectAllAdmins();

    void updateAdmin(Admin admin);

    void updateAdminId(@Param("oldId") String oldId, @Param("newId") String newId);
}
