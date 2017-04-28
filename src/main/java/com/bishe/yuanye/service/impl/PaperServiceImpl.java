package com.bishe.yuanye.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.PaperDTOExample;
import com.bishe.yuanye.dao.dto.PaperQuestionMapDTO;
import com.bishe.yuanye.dao.dto.PaperQuestionMapDTOExample;
import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.dao.dto.QuestionDTOExample;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTOExample;
import com.bishe.yuanye.dao.dto.TeacherPaperMapDTO;
import com.bishe.yuanye.dao.dto.TeacherPaperMapDTOExample;
import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.dao.mapper.PaperQuestionMapDTOMapper;
import com.bishe.yuanye.dao.mapper.QuestionDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentAnswerMapDTOMapper;
import com.bishe.yuanye.dao.mapper.TeacherPaperMapDTOMapper;
import com.bishe.yuanye.entity.Question;
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

    @Autowired
    private QuestionDTOMapper questionDTOMapper;

    @Autowired
    private PaperQuestionMapDTOMapper paperQuestionDTOMapper;

    @Autowired
    private TeacherPaperMapDTOMapper teacherPaperDTOMapper;

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

    @Override
    public List<Question> getQuestionByPaperId(Integer teacherId,Integer paperId) {
        //paper和teacher的关系
        TeacherPaperMapDTOExample ex1 = new TeacherPaperMapDTOExample();
        ex1.createCriteria().andTeacherIdEqualTo(teacherId).andPaperIdEqualTo(paperId).andIsDeletedEqualTo((short)0);
        List<TeacherPaperMapDTO> teacherPaperMapDTOS = teacherPaperDTOMapper.selectByExample(ex1);
        List<Integer> refPaperId = teacherPaperMapDTOS.stream().map(x -> x.getPaperId()).collect(Collectors.toList());
        //paper和question的关系
        PaperQuestionMapDTOExample ex2 = new PaperQuestionMapDTOExample();
        ex2.createCriteria().andPaperIdIn(refPaperId).andIsDeletedEqualTo((short)0);
        List<PaperQuestionMapDTO> paperQuestionMapDTOS = paperQuestionDTOMapper.selectByExample(ex2);
        List<Integer> questionIds = paperQuestionMapDTOS.stream().map(x -> x.getQuestionId()).collect(Collectors.toList());
        //获取question
        QuestionDTOExample example = new QuestionDTOExample();
        example.createCriteria().andIdIn(questionIds).andIsDeletedEqualTo((short)0);
        List<QuestionDTO> questionDTOS = questionDTOMapper.selectByExampleWithBLOBs(example);
        List<Question> collect = questionDTOS.stream().map(x -> {
            Question q = new Question();
            q.teacherId=x.getTeacherId();
            q.answer=x.getAnswer();
            q.chapterId=x.getChapterId();
            q.keywordOne=x.getKeywordOne();
            q.keywordTwo=x.getKeywordTwo();
            q.picOneUrl=x.getPicOneUrl();
            q.picTwoUrl=x.getPicTwoUrl();
            q.questionText=x.getQuestionText();
            q.type=x.getType();
            q.id=x.getId();
            return q;
        }).collect(Collectors.toList());
        return collect;
    }

}
