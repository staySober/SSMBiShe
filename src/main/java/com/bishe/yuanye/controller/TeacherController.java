package com.bishe.yuanye.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.entity.response.CountInfoResponse;
import com.bishe.yuanye.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuanye on 2017/5/3.
 *
 * @author yuanye
 * @date 2017/05/03
 */
@RequestMapping(value = "/teacher")
@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/getTeacherPapers")
    @ResponseBody
    public List<Paper> getTeacherPapers(HttpServletRequest request) {

        User user = (User)request.getSession().getAttribute("user");
        int teacherId = user.getId();
        List<Paper> paperList = teacherService.getTeacherPapers(teacherId);
        return paperList.isEmpty() ? new ArrayList<>() : paperList;
    }

    @RequestMapping(value = "/getCountInfo")
    @ResponseBody
    public CountInfoResponse getCountInfo(HttpServletRequest request) {

        User user = (User)request.getSession().getAttribute("user");
        int teacherId = user.getId();
        CountInfoResponse response = teacherService.getCountInfo(teacherId);
        return response;
    }
}
