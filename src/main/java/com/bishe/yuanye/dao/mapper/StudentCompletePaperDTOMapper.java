package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.StudentCompletePaperDTO;
import com.bishe.yuanye.dao.dto.StudentCompletePaperDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentCompletePaperDTOMapper {
    int countByExample(StudentCompletePaperDTOExample example);

    int insert(StudentCompletePaperDTO record);

    int insertSelective(StudentCompletePaperDTO record);

    List<StudentCompletePaperDTO> selectByExample(StudentCompletePaperDTOExample example);

    StudentCompletePaperDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentCompletePaperDTO record, @Param("example") StudentCompletePaperDTOExample example);

    int updateByExample(@Param("record") StudentCompletePaperDTO record, @Param("example") StudentCompletePaperDTOExample example);

    int updateByPrimaryKeySelective(StudentCompletePaperDTO record);

    int updateByPrimaryKey(StudentCompletePaperDTO record);
}