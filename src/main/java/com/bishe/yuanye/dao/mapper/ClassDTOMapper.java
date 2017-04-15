package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.ClassDTO;
import com.bishe.yuanye.dao.dto.ClassDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDTOMapper {
    int countByExample(ClassDTOExample example);

    int insert(ClassDTO record);

    int insertSelective(ClassDTO record);

    List<ClassDTO> selectByExample(ClassDTOExample example);

    ClassDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassDTO record, @Param("example") ClassDTOExample example);

    int updateByExample(@Param("record") ClassDTO record, @Param("example") ClassDTOExample example);

    int updateByPrimaryKeySelective(ClassDTO record);

    int updateByPrimaryKey(ClassDTO record);
}