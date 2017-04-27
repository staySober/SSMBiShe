package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuanye on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/questionBase")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/queryQuestion")
    @ResponseBody
    public QueryQuestionResponse queryQuestion(QueryQuestionRequest request) {

        QueryQuestionResponse response = questionService.queryQuestion(request);
        return response;
    }
}
