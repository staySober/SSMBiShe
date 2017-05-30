package com.bishe.yuanye.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bishe.yuanye.dao.dto.*;
import com.bishe.yuanye.dao.mapper.*;
import com.bishe.yuanye.entity.Paper;
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
public class
PaperServiceImpl implements PaperService {

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

    @Autowired
    private StudentCompletePaperDTOMapper studentCompletePaperMapper;

    @Autowired
    private TeacherDTOMapper teacherMapper;

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

        if(CollectionUtils.isEmpty(refPaperId)) {
            return new ArrayList<Question>();
        }
        //paper和question的关系
        PaperQuestionMapDTOExample ex2 = new PaperQuestionMapDTOExample();
        ex2.createCriteria().andPaperIdIn(refPaperId).andIsDeletedEqualTo((short)0);
        List<PaperQuestionMapDTO> paperQuestionMapDTOS = paperQuestionDTOMapper.selectByExample(ex2);
        List<Integer> questionIds = paperQuestionMapDTOS.stream().map(x -> x.getQuestionId()).collect(Collectors.toList());

         if(CollectionUtils.isEmpty(questionIds)) {
            return new ArrayList<Question>();
        }
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

    @Override
    public void submitPaper(Integer studentId, Integer paperId) {
        StudentCompletePaperDTO dto = new StudentCompletePaperDTO();
        dto.setIsDeleted((short)0);
        dto.setStudentId(studentId);
        dto.setPaperId(paperId);
        studentCompletePaperMapper.insert(dto);
    }

    @Override
    public List<StudentCompletePaperDTO> getPaperCompleteInfo(Integer studentId) {
        StudentCompletePaperDTOExample example = new StudentCompletePaperDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0).andStudentIdEqualTo(studentId);
        List<StudentCompletePaperDTO> paperDTOS = studentCompletePaperMapper.selectByExample(example);
        return paperDTOS;
    }

    @Override
    public List<Paper> getOtherPaper(int teacherId) {
        PaperDTOExample example = new PaperDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0).andTeacherIdNotEqualTo(teacherId).andIsVisibleEqualTo((short)1).andIsSharedEqualTo((short)1);
        List<PaperDTO> paperDTOS = paperMapper.selectByExample(example);
        return paperDTOS.stream().map(x->{
            Paper p = new Paper();
            p.setId(x.getId());
                p.setPaperName(x.getName());
                p.setPaperId(x.getId());
                p.setTeacherId(x.getTeacherId());
                p.setTeacherName(teacherMapper.selectByPrimaryKey(x.getTeacherId()).getName());
                return p;
        }).collect(Collectors.toList());
    }

}
