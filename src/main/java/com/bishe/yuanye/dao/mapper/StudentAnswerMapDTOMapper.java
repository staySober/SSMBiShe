package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentAnswerMapDTOMapper {
    int countByExample(StudentAnswerMapDTOExample example);

    int insert(StudentAnswerMapDTO record);

    int insertSelective(StudentAnswerMapDTO record);

    List<StudentAnswerMapDTO> selectByExampleWithBLOBs(StudentAnswerMapDTOExample example);

    List<StudentAnswerMapDTO> selectByExample(StudentAnswerMapDTOExample example);

    StudentAnswerMapDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentAnswerMapDTO record, @Param("example") StudentAnswerMapDTOExample example);

    int updateByExampleWithBLOBs(@Param("record") StudentAnswerMapDTO record, @Param("example") StudentAnswerMapDTOExample example);

    int updateByExample(@Param("record") StudentAnswerMapDTO record, @Param("example") StudentAnswerMapDTOExample example);

    int updateByPrimaryKeySelective(StudentAnswerMapDTO record);

    int updateByPrimaryKeyWithBLOBs(StudentAnswerMapDTO record);

    int updateByPrimaryKey(StudentAnswerMapDTO record);
}