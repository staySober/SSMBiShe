package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.AdminDTO;
import com.bishe.yuanye.dao.dto.AdminDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminDTOMapper {
    int countByExample(AdminDTOExample example);

    int insert(AdminDTO record);

    int insertSelective(AdminDTO record);

    List<AdminDTO> selectByExample(AdminDTOExample example);

    AdminDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminDTO record, @Param("example") AdminDTOExample example);

    int updateByExample(@Param("record") AdminDTO record, @Param("example") AdminDTOExample example);

    int updateByPrimaryKeySelective(AdminDTO record);

    int updateByPrimaryKey(AdminDTO record);
}