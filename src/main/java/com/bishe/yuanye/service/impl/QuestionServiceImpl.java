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
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        String a = "<p><span class=\"mathquill-rendered-math\" style=\"font-size:20px;\"><span "
            + "class=\"textarea\"><textarea data-cke-editable=\"1\" contenteditable=\"false\"></textarea></span><var "
            + "mathquill-command-id=\"4\">x</var><sup class=\"non-leaf\" mathquill-command-id=\"6\" "
            + "mathquill-block-id=\"7\"><span mathquill-command-id=\"9\">2</span><span "
            + "mathquill-command-id=\"10\">2</span></sup></span><span>&nbsp;</span>+<span "
            + "class=\"mathquill-rendered-math\" style=\"font-size:20px;\"><span class=\"textarea\"><textarea "
            + "data-cke-editable=\"1\" contenteditable=\"false\"></textarea></span><var "
            + "mathquill-command-id=\"21\">u</var><sub class=\"non-leaf\" mathquill-command-id=\"18\" "
            + "mathquill-block-id=\"19\"><var mathquill-command-id=\"22\">s</var></sub></span><span>&nbsp;"
            + "</span>\u200B<br></p>";
    }
}
