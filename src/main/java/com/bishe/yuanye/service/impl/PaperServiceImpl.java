package com.bishe.yuanye.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.PaperDTOExample;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTOExample;
import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentAnswerMapDTOMapper;
import com.bishe.yuanye.service.PaperService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDTOMapper paperMapper;

    @Autowired
	private StudentAnswerMapDTOMapper studentAnswerMapMapper;

    @Override
    public List<PaperDTO> getPaperByTeacherId(int id) {
        PaperDTOExample example =new PaperDTOExample();
        example.createCriteria().andTeacherIdEqualTo(id).andIsDeletedEqualTo((short)0);
        List<PaperDTO> paperDTOS = paperMapper.selectByExample(example);
        return paperDTOS;
    }

    @Override
    public List<StudentAnswerMapDTO> getStudentAnswerRelation(Integer studentId) {
        StudentAnswerMapDTOExample example = new StudentAnswerMapDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0).andStudentIdEqualTo(studentId);
        List<StudentAnswerMapDTO> answerMapDTOS = studentAnswerMapMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(answerMapDTOS)){
            return answerMapDTOS;
        }
        return new ArrayList<>();
    }

}
