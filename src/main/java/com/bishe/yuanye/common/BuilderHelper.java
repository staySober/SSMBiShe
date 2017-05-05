package com.bishe.yuanye.common;

import com.bishe.yuanye.dao.dto.ChapterDTO;
import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.QueryConditionDTO;
import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.entity.ChapterInfo;
import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.QuestionQueryCondition;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QuestionWithDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanye on 2017/3/17.
 *
 * @author yuanye
 */
public class BuilderHelper {

    public static QuestionDTO buildQuestionDTO(Question question) {

        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setChapterId(question.chapterId);
        questionDTO.setKeywordOne(question.keywordOne);
        questionDTO.setKeywordTwo(question.keywordTwo);
        questionDTO.setType(question.type);
        questionDTO.setQuestionText(question.questionText);
        questionDTO.setPicOneUrl(question.picOneUrl);
        questionDTO.setPicTwoUrl(question.picTwoUrl);
        questionDTO.setAnswer(question.answer);
        questionDTO.setTeacherId(question.teacherId);
        questionDTO.setCreatedAt(new Date());
        questionDTO.setIsDeleted((short)0);
        return questionDTO;
    }

    public static Question buildQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.chapterId = questionDTO.getChapterId();
        question.keywordOne = questionDTO.getKeywordOne();
        question.keywordTwo = questionDTO.getKeywordTwo();
        question.type = questionDTO.getType();
        question.questionText = questionDTO.getQuestionText();
        question.picOneUrl = questionDTO.getPicOneUrl();
        question.picTwoUrl = questionDTO.getPicTwoUrl();
        question.answer = questionDTO.getAnswer();
        question.teacherId = questionDTO.getTeacherId();
        return question;
    }

    public static QueryConditionDTO buildQueryCondition(QueryQuestionRequest request) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QueryConditionDTO conditionDTO = new QueryConditionDTO();
        if (request.chapterId > 0) {
            conditionDTO.setChapterId(request.chapterId);
        }
        if (!StringUtils.isEmpty(request.keyword)) {
            conditionDTO.setKeyword(request.keyword);
        }
        if (!StringUtils.isEmpty(request.type)) {
            conditionDTO.setType(request.type);
        }
        if (!StringUtils.isEmpty(request.teacherName)) {
            conditionDTO.setTeacherName(request.teacherName);
        }
        if (!StringUtils.isEmpty(request.startTime)) {
            conditionDTO.setStartTime(format.parse(request.startTime + " 00:00:00"));
        }
        if (!StringUtils.isEmpty(request.endTime)) {
            conditionDTO.setEndTime(format.parse(request.endTime + " 23:59:59"));
        }
        return conditionDTO;
    }

    public static QuestionWithDetail buildQuestionWithDetail(QuestionDTO questionDTO) {

        QuestionWithDetail questionWithDetail = new QuestionWithDetail();
        questionWithDetail.id = questionDTO.getId();
        questionWithDetail.chapterName = questionDTO.getChapterName();
        questionWithDetail.chapterId = questionDTO.getChapterId();
        questionWithDetail.type = questionDTO.getType();
        questionWithDetail.questionText = questionDTO.getQuestionText();
        questionWithDetail.teacherId = questionDTO.getTeacherId();
        questionWithDetail.teacherName = questionDTO.getTeacherName();
        questionWithDetail.picOneUrl = "../../files/" + questionDTO.getPicOneUrl();
        questionWithDetail.answer = questionDTO.getAnswer();
        questionWithDetail.createdAt = CommonUtil.formatDateToString(questionDTO.getCreatedAt());
        questionWithDetail.allKeyword = questionDTO.getKeywordOne();
        if (!StringUtils.isEmpty(questionDTO.getKeywordTwo())) {
            questionWithDetail.allKeyword += ("," + questionDTO.getKeywordTwo());
        }
        return questionWithDetail;
    }

    public static ChapterInfo buildChapterInfo(ChapterDTO chapterDTO) {

        ChapterInfo chapterInfo = new ChapterInfo();
        chapterInfo.id = chapterDTO.getId();
        chapterInfo.chapterName = chapterDTO.getName();
        return chapterInfo;
    }
}
