package week01.project.mapper;

import org.apache.ibatis.annotations.Param;
import week01.project.pojo.Repair;

import java.util.List;

public interface RepairMapper {

    void insertRepair(Repair repair);

    void deleteRepairById(int id);

    List<Repair> selectByStatus(String Status);

    List<Repair> selectAll();

    Repair selectById(int Id);

    void updateRepair(Repair repair);

    void updateRepairId(@Param("oldId") int oldId, @Param("newId") int newId);


}
