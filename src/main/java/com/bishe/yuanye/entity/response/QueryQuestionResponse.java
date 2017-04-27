package com.bishe.yuanye.entity.response;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanye on 2017/4/24.
 */
public class QueryQuestionResponse {

    public List<QuestionWithDetail> questionList = new ArrayList<>();

    public String errorMsg;

    public QueryQuestionResponse() {
    }

    public QueryQuestionResponse(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
