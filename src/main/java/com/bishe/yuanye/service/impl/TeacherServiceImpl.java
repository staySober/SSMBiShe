package com.bishe.yuanye.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bishe.yuanye.dao.dto.ClassDTOExample;
import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.PaperDTOExample;
import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.dao.dto.QuestionDTOExample;
import com.bishe.yuanye.dao.dto.StudentDTOExample;
import com.bishe.yuanye.dao.dto.TeacherDTO;
import com.bishe.yuanye.dao.mapper.ClassDTOMapper;
import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.dao.mapper.QuestionDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import com.bishe.yuanye.dao.mapper.TeacherDTOMapper;
import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.entity.response.CountInfoResponse;
import com.bishe.yuanye.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/4/28.
 *
 * @author sober
 * @date 2017/04/28
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    QuestionDTOMapper questionDTOMapper;

    @Autowired
    StudentDTOMapper studentDTOMapper;

    @Autowired
    ClassDTOMapper classDTOMapper;

    @Autowired
    TeacherDTOMapper teacherDTOMapper;

    @Autowired
    PaperDTOMapper paperDTOMapper;

    @Override
    public void delTeacher(Integer teacherId) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacherId);
        dto.setIsDeleted((short)0);
        teacherDTOMapper.updateByPrimaryKeySelective(dto);
    }

    @Override
    public List<Paper> getTeacherPapers(int teacherId) {

        PaperDTOExample example = new PaperDTOExample();
        example.createCriteria().andTeacherIdEqualTo(teacherId).andIsDeletedEqualTo((short)0);
        List<PaperDTO> paperDTOList = paperDTOMapper.selectByExample(example);
        if (paperDTOList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return paperDTOList.stream().map(paperDTO -> buildTeacherPaper(paperDTO)).collect(Collectors.toList());
        }
    }

    @Override
    public CountInfoResponse getCountInfo(int teacherId) {

        CountInfoResponse response = new CountInfoResponse();
        QuestionDTOExample example1 = new QuestionDTOExample();
        example1.createCriteria().andTeacherIdEqualTo(teacherId).andIsDeletedEqualTo((short)0);
        response.questionCount = questionDTOMapper.countByExample(example1);

        PaperDTOExample example2 = new PaperDTOExample();
        example2.createCriteria().andTeacherIdEqualTo(teacherId).andIsDeletedEqualTo((short)0);
        response.paperCount = paperDTOMapper.countByExample(example2);

        StudentDTOExample example3 = new StudentDTOExample();
        example3.createCriteria().andTeacherIdEqualTo(teacherId).andIsDeletedEqualTo((short)0);
        response.studentCount = studentDTOMapper.countByExample(example3);

        ClassDTOExample example4 = new ClassDTOExample();
        example4.createCriteria().andTeacherIdEqualTo(teacherId).andIsDeletedEqualTo((short)0);
        response.classCount = classDTOMapper.countByExample(example4);
        return response;
    }

    private Paper buildTeacherPaper(PaperDTO paperDTO) {

        Paper paper = new Paper();
        paper.setId(paperDTO.getId());
        paper.setPaperName(paperDTO.getName());
        paper.setTeacherId(paperDTO.getTeacherId());
        return paper;
    }
}
