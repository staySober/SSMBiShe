package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.QuestionAnswer;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.service.AnswerService;
import com.bishe.yuanye.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 *
 * 这里设置为/paper 的原因是cookie的路径问题，如果不在同一个路径是取不到cookies的，（使用html 算一个非常不友好的地方吧）
 */
@Controller
@RequestMapping(value = "/paper")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private PaperService paperService;


    @RequestMapping(value = "/setAnswer", method = RequestMethod.POST)
    public String setAnswer(HttpServletRequest request){
        String questionId = request.getParameter("questionId");

        Cookie cookie = Arrays.stream(request.getCookies()).filter(x -> "paperId".equals(x.getName())).findAny().get();
        String paperId = cookie.getValue();

        User user = (User)request.getSession().getAttribute("user");
        Integer studentId = user.getId();

        String answer = request.getParameter("answer");
        //todo 设置答案之前先检测之前是否有答案  如果有删除
        answerService.delAnswer(studentId,Integer.parseInt(paperId), Integer.parseInt(questionId));

        answerService.setAnswer(studentId,Integer.parseInt(paperId), Integer.parseInt(questionId),answer);
        return "redirect:/html/student/paperAnswer.html?paperId="+paperId;
    }

    @RequestMapping(value = "/getStudentAnswerInfo")
    @ResponseBody
    public List<QuestionAnswer> getStudentAnswerInfo(HttpServletRequest request){
        //question
        User user = (User)request.getSession().getAttribute("user");
        Cookie cookie = Arrays.stream(request.getCookies()).filter(x -> "paperId".equals(x.getName())).findAny().get();
        List<Question> questions = paperService.getQuestionByPaperId(user.getTeacherId(),Integer.parseInt(cookie.getValue()));
        //answer
        List<QuestionAnswer> collect = questions.stream().map(x -> {
            QuestionAnswer q = new QuestionAnswer();
            q.setQuestion(x);
            String answer = answerService.queryAnswer(x.id, Integer.parseInt(cookie.getValue()),user.getId());
            q.setStudentAnswer(answer == null ? "" : answer);
            return q;
        }).collect(Collectors.toList());
        return collect;
    }
}
