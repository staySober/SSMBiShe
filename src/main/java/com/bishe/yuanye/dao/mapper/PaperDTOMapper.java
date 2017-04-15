package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.PaperDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDTOMapper {
    int countByExample(PaperDTOExample example);

    int insert(PaperDTO record);

    int insertSelective(PaperDTO record);

    List<PaperDTO> selectByExample(PaperDTOExample example);

    PaperDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaperDTO record, @Param("example") PaperDTOExample example);

    int updateByExample(@Param("record") PaperDTO record, @Param("example") PaperDTOExample example);

    int updateByPrimaryKeySelective(PaperDTO record);

    int updateByPrimaryKey(PaperDTO record);
}