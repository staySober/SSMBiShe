package com.bishe.yuanye.common;

import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.entity.Question;

import java.util.Date;

/**
 * Created by yuanye on 2017/3/17.
 */
public class BuilderHelper {

    public static QuestionDTO buildQuestionDTO(Question question) {

        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setChapter(question.getChapter());
        questionDTO.setKeywordOne(question.getKeywordOne());
        questionDTO.setKeywordTwo(question.getKeywordTwo());
        questionDTO.setType(question.getType());
        questionDTO.setQuestionText(question.getQuestionText());
        questionDTO.setPicOneUrl(question.getPicOneUrl());
        questionDTO.setPicTwoUrl(question.getPicTwoUrl());
        questionDTO.setAnswer(question.getAnswer());
        questionDTO.setTeacherId(question.getTeacherId());
        questionDTO.setCreatedAt(new Date());
        questionDTO.setIsDeleted((short) 0);
        return questionDTO;
    }

    public static Question buildQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setChapter(questionDTO.getChapter());
        question.setKeywordOne(questionDTO.getKeywordOne());
        question.setKeywordTwo(questionDTO.getKeywordTwo());
        question.setType(questionDTO.getType());
        question.setQuestionText(questionDTO.getQuestionText());
        question.setPicOneUrl(questionDTO.getPicOneUrl());
        question.setPicTwoUrl(questionDTO.getPicTwoUrl());
        question.setAnswer(questionDTO.getAnswer());
        question.setTeacherId(questionDTO.getTeacherId());
        return question;
    }
}
