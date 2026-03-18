package week01.project.mapper;

import week01.project.pojo.Repair;

import java.util.List;

public interface RepairMapper {

    List<Repair> selectByStatus(String Status);

    List<Repair> selectAll();

    List<Repair> selectById(String Id);


}
