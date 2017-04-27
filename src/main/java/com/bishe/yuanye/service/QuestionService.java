package com.bishe.yuanye.service;

import com.bishe.yuanye.entity.QuestionQueryCondition;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;

/**
 * Created by yuanye on 2017/4/24.
 */
public interface QuestionService {

    QueryQuestionResponse queryQuestion(QueryQuestionRequest request);
}
