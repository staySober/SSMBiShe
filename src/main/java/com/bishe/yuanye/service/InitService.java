package com.bishe.yuanye.service;

import com.bishe.yuanye.entity.Question;

/**
 * Created by yuanye on 2017/3/17.
 */
public interface InitService {

    void submitQuestion(Question question);

    Question getQuestionById(int questionId);
}
