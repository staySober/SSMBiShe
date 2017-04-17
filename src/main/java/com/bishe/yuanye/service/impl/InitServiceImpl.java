package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.common.BuilderHelper;
import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.dao.mapper.InitDTOMapper;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanye on 2017/3/17.
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    InitDTOMapper initDTOMapper;

    @Override
    public void submitQuestion(Question question) {

        QuestionDTO questionDTO = BuilderHelper.buildQuestionDTO(question);
        initDTOMapper.insert(questionDTO);
    }

    @Override
    public Question getQuestionById(int questionId) {
        QuestionDTO questionDTO = initDTOMapper.selectById(questionId);
        Question question = BuilderHelper.buildQuestion(questionDTO);
        return question;
    }
}
