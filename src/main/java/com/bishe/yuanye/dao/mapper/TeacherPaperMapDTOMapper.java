package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.TeacherPaperMapDTO;
import com.bishe.yuanye.dao.dto.TeacherPaperMapDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherPaperMapDTOMapper {
    int countByExample(TeacherPaperMapDTOExample example);

    int insert(TeacherPaperMapDTO record);

    int insertSelective(TeacherPaperMapDTO record);

    List<TeacherPaperMapDTO> selectByExample(TeacherPaperMapDTOExample example);

    TeacherPaperMapDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherPaperMapDTO record, @Param("example") TeacherPaperMapDTOExample example);

    int updateByExample(@Param("record") TeacherPaperMapDTO record, @Param("example") TeacherPaperMapDTOExample example);

    int updateByPrimaryKeySelective(TeacherPaperMapDTO record);

    int updateByPrimaryKey(TeacherPaperMapDTO record);
}