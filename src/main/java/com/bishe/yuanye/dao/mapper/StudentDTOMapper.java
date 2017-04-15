package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.StudentDTO;
import com.bishe.yuanye.dao.dto.StudentDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDTOMapper {
    int countByExample(StudentDTOExample example);

    int insert(StudentDTO record);

    int insertSelective(StudentDTO record);

    List<StudentDTO> selectByExample(StudentDTOExample example);

    StudentDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentDTO record, @Param("example") StudentDTOExample example);

    int updateByExample(@Param("record") StudentDTO record, @Param("example") StudentDTOExample example);

    int updateByPrimaryKeySelective(StudentDTO record);

    int updateByPrimaryKey(StudentDTO record);
}