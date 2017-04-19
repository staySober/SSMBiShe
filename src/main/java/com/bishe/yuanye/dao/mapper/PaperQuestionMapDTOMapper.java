package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.PaperQuestionMapDTO;
import com.bishe.yuanye.dao.dto.PaperQuestionMapDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperQuestionMapDTOMapper {
    int countByExample(PaperQuestionMapDTOExample example);

    int insert(PaperQuestionMapDTO record);

    int insertSelective(PaperQuestionMapDTO record);

    List<PaperQuestionMapDTO> selectByExample(PaperQuestionMapDTOExample example);

    PaperQuestionMapDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaperQuestionMapDTO record, @Param("example") PaperQuestionMapDTOExample example);

    int updateByExample(@Param("record") PaperQuestionMapDTO record, @Param("example") PaperQuestionMapDTOExample example);

    int updateByPrimaryKeySelective(PaperQuestionMapDTO record);

    int updateByPrimaryKey(PaperQuestionMapDTO record);
}