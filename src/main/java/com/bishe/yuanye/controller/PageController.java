package com.bishe.yuanye.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.dto.StudentCompletePaperDTO;
import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.entity.request.PaperSetSharedRequest;
import com.bishe.yuanye.entity.request.PaperSetVisibleRequest;
import com.bishe.yuanye.entity.response.QuestionWithDetail;
import com.bishe.yuanye.service.AnswerService;
import com.bishe.yuanye.service.PaperService;
import com.bishe.yuanye.service.QuestionService;
import com.bishe.yuanye.service.StudentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sober on 2017/4/13.
 */
@Controller
@RequestMapping(value = "/paper")
public class PageController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private QuestionService questionService;

    @Value("${saveImageUrl}")
    private String saveImageUrl;

    /**
     * 获取试卷集的方法
     */
    @ResponseBody
    @RequestMapping(value = "/getPaperList")
    public List<Paper> getPaperList(HttpServletRequest request) {
        Integer studentId = Integer.valueOf(request.getParameter("studentId"));
        //通过studentId 找到对应teacherId
        Integer teacherId = studentService.getTeacherIdByStudentId(studentId);
        //通过teacherId 找到对应paperId
        List<PaperDTO> paperDTOList = paperService.getPaperByTeacherId(teacherId);
        //通过student_answer_map 判断是否已答题该试卷
        List<StudentAnswerMapDTO> answerMapDTOS = paperService.getStudentAnswerRelation(studentId);
        //结果集封装
        List<Paper> paperList = paperDTOList.stream().map(x -> {
                Paper paper = new Paper();
                paper.setId(x.getId());
                paper.setPaperName(x.getName());
                paper.setPaperId(x.getId());
                paper.setStudentId(studentId);
                return paper;
            }
        ).collect(Collectors.toList());

        //查询题目作答情况
        List<StudentCompletePaperDTO> paperDTOS = paperService.getPaperCompleteInfo(studentId);
        List<Integer> paperIdList = paperDTOS.stream().mapToInt(x -> x.getPaperId()).boxed().collect(
            Collectors.toList());
        paperList.forEach(paper -> {
            //todo 重构已完成为完成试卷判断逻辑
            if (paperIdList.contains(paper.getPaperId())) {
                paper.setAnswer(true);
            }
        });
        return paperList;
    }

    @RequestMapping("/getPaper")
    public String getPaper(Integer paperId, HttpServletResponse response) {
        Cookie cookie = new Cookie("paperId", paperId.toString());
        cookie.setPath("/");
        response.addCookie(cookie);
        return "student/paperAnswer";
    }

    @RequestMapping("/getPaperContent")
    @ResponseBody
    public List<Question> getPaperContent(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        Cookie cookie = Arrays.stream(request.getCookies()).filter(x -> "paperId".equals(x.getName())).findAny().get();
        List<Question> questions = paperService.getQuestionByPaperId(user.getTeacherId(),
            Integer.parseInt(cookie.getValue()));
        questions.stream().forEach(x -> {
            x.setPicOneUrl("../../files/" + x.getPicOneUrl());
        });
        return questions;
    }

    @RequestMapping("/getStudentAnswer")
    public String getStudentAnswer(HttpServletRequest request, HttpServletResponse response) {
        String paperId = request.getParameter("paperId");
        Cookie cookie = new Cookie("paperId", paperId.toString());
        cookie.setPath("/");
        response.addCookie(cookie);
        return "student/answerInfo";
    }

    @RequestMapping("/getTrueAnswer")
    public String getTrueAnswer(HttpServletRequest request, HttpServletResponse response) {
        String paperId = request.getParameter("paperId");
        Cookie cookie = new Cookie("paperId", paperId.toString());
        cookie.setPath("/");
        response.addCookie(cookie);
        return "student/trueAnswer";
    }

    @RequestMapping("/submitPaper")
    public String submitPaper(HttpServletRequest request) {
        Cookie cookie = Arrays.stream(request.getCookies()).filter(x -> x.getName().equals("paperId")).findAny().get();
        Integer paperId = Integer.parseInt(cookie.getValue());
        User user = (User)request.getSession().getAttribute("user");
        Integer studentId = user.getId();
        paperService.submitPaper(studentId, paperId);
        return "success";
    }

    @RequestMapping("/getOtherPaper")
    @ResponseBody
    public List<Paper> getOtherPaper(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        int teacherId = user.getId();
        return paperService.getOtherPaper(teacherId);
    }

    @RequestMapping("/setShared")
    @ResponseBody
    public void setShared(PaperSetSharedRequest request) {

        int paperId = request.paperId;
        int isShared = request.isShared;
        paperService.setShared(paperId, isShared);
    }

    @RequestMapping("/setVisible")
    @ResponseBody
    public void setVisible(PaperSetVisibleRequest request) {

        int paperId = request.paperId;
        int isVisible = request.isVisible;
        paperService.setVisible(paperId, isVisible);
    }

    @RequestMapping("/selectPaperQuestion")
    @ResponseBody
    public List<QuestionWithDetail> selectPaperQuestion(int paperId) {

        return paperService.getPaperQuestion(paperId);
    }
}
