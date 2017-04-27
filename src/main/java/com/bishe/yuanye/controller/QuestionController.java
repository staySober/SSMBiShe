package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.QuestionQueryCondition;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuanye on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/questionBase")
public class QuestionController {

    @RequestMapping(value = "/queryQuestion")
    @ResponseBody
    public QueryQuestionResponse queryQuestion(QuestionQueryCondition condition) {


        return null;
    }
}
