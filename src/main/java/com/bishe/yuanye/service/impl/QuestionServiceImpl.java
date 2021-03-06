package com.bishe.yuanye.service.impl;

import com.alibaba.fastjson.JSON;

import com.bishe.yuanye.common.BuilderHelper;
import com.bishe.yuanye.dao.dto.*;
import com.bishe.yuanye.dao.mapper.ChapterDTOMapper;
import com.bishe.yuanye.dao.mapper.PaperQuestionMapDTOMapper;
import com.bishe.yuanye.dao.mapper.QuestionDTOMapper;
import com.bishe.yuanye.entity.ChapterInfo;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.AddToPaperResponse;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yuanye on 2017/4/24.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDTOMapper questionDTOMapper;

    @Autowired
    PaperQuestionMapDTOMapper paperQuestionDTOMapper;

    @Autowired
    ChapterDTOMapper chapterDTOMapper;

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Override
    public QueryQuestionResponse queryQuestion(QueryQuestionRequest request) {
        try {
            QueryQuestionResponse response = new QueryQuestionResponse();
            QueryConditionDTO queryConditionDTO = BuilderHelper.buildQueryCondition(request);
            queryConditionDTO.setPageSize(request.pageSize);
            queryConditionDTO.setOffset((request.pageIndex - 1) * request.pageSize);
            List<QuestionDTO> questionDTOList = questionDTOMapper.queryQuestionByCondition(queryConditionDTO);
            if (questionDTOList.isEmpty()) {
                return response;
            }
            response.questionList = questionDTOList.stream().map(
                questionDTO -> BuilderHelper.buildQuestionWithDetail(questionDTO)).collect(Collectors.toList());
            return response;
        } catch (ParseException pe) {
            logger.error("查询题库时转化时间格式失败,查询条件:{}", JSON.toJSONString(request), pe);
            return new QueryQuestionResponse("查询条件异常");
        } catch (Exception e) {
            logger.error("题库查询失败,查询条件:{}", JSON.toJSONString(request), e);
            return new QueryQuestionResponse("查询失败");
        }
    }

    @Override
    public List<Integer> getQuestionIdListByPaperId(int paperId) {
        PaperQuestionMapDTOExample example = new PaperQuestionMapDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0).andPaperIdEqualTo(paperId);
        List<PaperQuestionMapDTO> paperQuestionMapDTOS = paperQuestionDTOMapper.selectByExample(example);
        List<Integer> collect = paperQuestionMapDTOS.stream().mapToInt(x -> x.getQuestionId()).boxed().collect(
            Collectors.toList());
        return collect;
    }

    @Override
    public List<ChapterInfo> getAllChapters() {

        ChapterDTOExample example = new ChapterDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0);
        List<ChapterDTO> chapterDTOList = chapterDTOMapper.selectByExample(example);
        if (!chapterDTOList.isEmpty()) {
            return chapterDTOList.stream().map(chapterDTO -> BuilderHelper.buildChapterInfo(chapterDTO)).collect(
                Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public int createQuestion(Question question) {
        try {
            QuestionDTO questionDTO = BuilderHelper.buildQuestionDTO(question);
            return questionDTOMapper.insert(questionDTO);
        } catch (Exception e) {
            logger.error("新建题目失败,题目:{}", JSON.toJSONString(question), e);
            return 0;
        }
    }

    @Override
    public int updateQuestion(Question question) {
        try {
            QuestionDTO questionDTO = BuilderHelper.buildQuestionDTOForUpdate(question);
            return questionDTOMapper.updateByPrimaryKeySelective(questionDTO);
        } catch (Exception e) {
            logger.error("更新题目失败,题目:{}", JSON.toJSONString(question), e);
            return 0;
        }
    }

    @Override
    public Question queryQuestionById(int id) {

        QuestionDTO questionDTO = questionDTOMapper.selectByPrimaryKey(id);

        return BuilderHelper.buildQuestion(questionDTO);
    }

    @Override
    public AddToPaperResponse addToPaper(int questionId, int paperId) throws Exception{

        AddToPaperResponse response = new AddToPaperResponse();
        PaperQuestionMapDTOExample example = new PaperQuestionMapDTOExample();
        example.createCriteria().andQuestionIdEqualTo(questionId).andPaperIdEqualTo(paperId);
        int num = paperQuestionDTOMapper.countByExample(example);
        if (num == 0) {
            PaperQuestionMapDTO dto = new PaperQuestionMapDTO();
            dto.setQuestionId(questionId);
            dto.setPaperId(paperId);
            dto.setScore(0);
            dto.setIsDeleted((short)0);
            dto.setCreatedAt(new Date());
            paperQuestionDTOMapper.insert(dto);
            response.isSuccess =1;
            response.msg="加入成功";
        } else {
            response.isSuccess = 0;
            response.msg = "题目已在试卷当中";
        }
        return response;
    }

}
