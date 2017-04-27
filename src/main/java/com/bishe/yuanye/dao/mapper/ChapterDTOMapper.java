package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.ChapterDTO;
import com.bishe.yuanye.dao.dto.ChapterDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChapterDTOMapper {
    int countByExample(ChapterDTOExample example);

    int insert(ChapterDTO record);

    int insertSelective(ChapterDTO record);

    List<ChapterDTO> selectByExample(ChapterDTOExample example);

    ChapterDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChapterDTO record, @Param("example") ChapterDTOExample example);

    int updateByExample(@Param("record") ChapterDTO record, @Param("example") ChapterDTOExample example);

    int updateByPrimaryKeySelective(ChapterDTO record);

    int updateByPrimaryKey(ChapterDTO record);
}