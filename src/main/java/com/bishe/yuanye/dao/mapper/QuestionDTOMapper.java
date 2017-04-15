package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.dao.dto.QuestionDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDTOMapper {
    int countByExample(QuestionDTOExample example);

    int insert(QuestionDTO record);

    int insertSelective(QuestionDTO record);

    List<QuestionDTO> selectByExampleWithBLOBs(QuestionDTOExample example);

    List<QuestionDTO> selectByExample(QuestionDTOExample example);

    QuestionDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionDTO record, @Param("example") QuestionDTOExample example);

    int updateByExampleWithBLOBs(@Param("record") QuestionDTO record, @Param("example") QuestionDTOExample example);

    int updateByExample(@Param("record") QuestionDTO record, @Param("example") QuestionDTOExample example);

    int updateByPrimaryKeySelective(QuestionDTO record);

    int updateByPrimaryKeyWithBLOBs(QuestionDTO record);

    int updateByPrimaryKey(QuestionDTO record);
}