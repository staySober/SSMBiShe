package com.bishe.yuanye.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.common.CommonUtil;
import com.bishe.yuanye.entity.ChapterInfo;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.entity.response.SavePictureResponse;
import com.bishe.yuanye.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by yuanye on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/questionBase")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Value("${saveImageUrl}")
    private String saveImageUrl;

    @RequestMapping(value = "/queryQuestion")
    @ResponseBody
    public QueryQuestionResponse queryQuestion(QueryQuestionRequest request) {

        QueryQuestionResponse response = questionService.queryQuestion(request);
        return response;
    }

    @RequestMapping(value = "/savePicture")
    @ResponseBody
    public SavePictureResponse savePicture(@RequestParam("file") CommonsMultipartFile file,
        HttpServletRequest request) {

        SavePictureResponse response = new SavePictureResponse();
        String newFileName = CommonUtil.getNewRandomName(file.getOriginalFilename());
        if (CommonUtil.isRightPictureFormat(newFileName)) {
            String path = request.getSession().getServletContext().getRealPath(saveImageUrl) + "/" + newFileName;
            File newFile = new File(path);
            if (newFile.exists()) {
                response.errorMsg = "文件已存在,请重命名";
            } else {
                try {
                    file.transferTo(newFile);
                    response.fileName = newFileName;
                } catch (Exception e) {
                    response.errorMsg = "文件保存失败";
                }
            }
        } else {
            response.errorMsg = "文件格式错误";
        }
        return response;
    }

    @RequestMapping(value = "/getAllChapters")
    @ResponseBody
    public List<ChapterInfo> getAllChapters() {

        List<ChapterInfo> chapterInfoList = questionService.getAllChapters();
        return chapterInfoList;
    }

    @RequestMapping(value = "/createQuestion")
    @ResponseBody
    public int createQuestion(Question question, HttpServletRequest request, Model model) throws Exception {

        User user = (User)request.getSession().getAttribute("user");
        question.teacherId = user.getId();
        int i = questionService.createQuestion(question);
        if (i == 1) {
            return i;
        } else {
            throw new Exception();
        }
    }

}
