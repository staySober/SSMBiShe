package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.TeacherDTO;
import com.bishe.yuanye.dao.dto.TeacherDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDTOMapper {
    int countByExample(TeacherDTOExample example);

    int insert(TeacherDTO record);

    int insertSelective(TeacherDTO record);

    List<TeacherDTO> selectByExample(TeacherDTOExample example);

    TeacherDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherDTO record, @Param("example") TeacherDTOExample example);

    int updateByExample(@Param("record") TeacherDTO record, @Param("example") TeacherDTOExample example);

    int updateByPrimaryKeySelective(TeacherDTO record);

    int updateByPrimaryKey(TeacherDTO record);
}