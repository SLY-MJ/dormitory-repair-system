package week01.project.service;

import org.apache.ibatis.session.SqlSession;
import week01.project.mapper.AdminMapper;
import week01.project.mapper.RepairMapper;
import week01.project.pojo.Repair;

import java.util.List;

public class AdminService extends UserService {
    public List<Repair> selectRepairByStatus(String status) {
        if (!(status.equals("已完成") || status.equals("未完成"))){
            throw new RuntimeException("状态格式错误");
        }

        try (SqlSession session = getFactory().openSession(false)) {
            RepairMapper mapper = session.getMapper(RepairMapper.class);
            List<Repair> list = mapper.selectByStatus("status");
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
