package com.bishe.yuanye.entity.request;

import com.bishe.yuanye.entity.QuestionQueryCondition;

/**
 * Created by yuanye on 2017/4/24.
 */
public class QueryQuestionRequest {

    public int pageIndex = 1;

    public int pageSize = 5;

    public QuestionQueryCondition questionQueryCondition;


}
