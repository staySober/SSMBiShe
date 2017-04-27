package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuanye on 2017/2/24.
 */
@Controller
@RequestMapping(value = "/questionDB")
public class InitController {

    @Autowired
    InitService initService;

    @RequestMapping(value = "/submitQuestion", method = RequestMethod.GET)
    public String submitQuestion(Question question) {
        initService.submitQuestion(question);
        return "home";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    @ResponseBody
    public Question displayQuestion(@RequestParam(value = "questionId") Integer questionId) {

        Question question = initService.getQuestionById(questionId);
//        String json = JSON.toJSONString(question);
//        model.addAttribute(json);
//        return "display";
        return question;
    }
}
