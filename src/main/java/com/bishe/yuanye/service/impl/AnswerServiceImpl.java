package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTOExample;
import com.bishe.yuanye.dao.mapper.StudentAnswerMapDTOMapper;
import com.bishe.yuanye.service.AnswerService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private StudentAnswerMapDTOMapper studentAnswerDTOMapper;

    @Override
    public void setAnswer(Integer studentId, Integer paperId, Integer questionId, String answer) {
        StudentAnswerMapDTO dto = new StudentAnswerMapDTO();
        dto.setIsDeleted((short)0);
        dto.setAnswer(answer);
        dto.setPaperId(paperId);
        dto.setQuestionId(questionId);
        dto.setStudentId(studentId);
        studentAnswerDTOMapper.insert(dto);
    }

    @Override
    public void delAnswer(Integer studentId, Integer paperId, Integer questionId) {
        StudentAnswerMapDTOExample ex = new StudentAnswerMapDTOExample();
        ex.createCriteria().andIsDeletedEqualTo((short)0).andStudentIdEqualTo(studentId).andPaperIdEqualTo(paperId).andQuestionIdEqualTo(questionId);
        StudentAnswerMapDTO dto = new StudentAnswerMapDTO();
        dto.setIsDeleted((short)1);
        studentAnswerDTOMapper.updateByExampleSelective(dto,ex);
    }

    @Override
    public String queryAnswer(Integer questionId, Integer paperId, Integer studentId) {
        StudentAnswerMapDTOExample ex = new StudentAnswerMapDTOExample();
        ex.createCriteria().andIsDeletedEqualTo((short)0).andQuestionIdEqualTo(questionId).andPaperIdEqualTo(paperId).andStudentIdEqualTo(studentId);
        List<StudentAnswerMapDTO> studentAnswerMapDTOS = studentAnswerDTOMapper.selectByExampleWithBLOBs(ex);
        return CollectionUtils.isNotEmpty(studentAnswerMapDTOS)? studentAnswerMapDTOS.get(0).getAnswer() : "";
    }

}
