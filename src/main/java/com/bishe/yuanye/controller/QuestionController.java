package com.bishe.yuanye.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.common.CommonUtil;
import com.bishe.yuanye.entity.ChapterInfo;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.AddToPaperResponse;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.entity.response.QuestionWithDetail;
import com.bishe.yuanye.entity.response.SavePictureResponse;
import com.bishe.yuanye.service.QuestionService;
import com.bishe.yuanye.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by yuanye on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/questionBase")
public class QuestionController {

    @Autowired
    QuestionService questionService;



    @Value(value = "${URL}")
    private String URL;

    @RequestMapping(value = "/queryQuestion")
    @ResponseBody
    public QueryQuestionResponse queryQuestion(QueryQuestionRequest request) {

        QueryQuestionResponse response = questionService.queryQuestion(request);
        return response;
    }

    @RequestMapping(value = "/queryQuestionById")
    @ResponseBody
    public QuestionWithDetail queryQuestionById(int id) {

        QueryQuestionRequest request = new QueryQuestionRequest();
        request.id = id;
        QueryQuestionResponse response = questionService.queryQuestion(request);
        return response.questionList.get(0);
    }

    @RequestMapping(value = "/savePicture")
    @ResponseBody
    public SavePictureResponse savePicture(@RequestParam("file") CommonsMultipartFile file,
                                           HttpServletRequest request) {

        SavePictureResponse response = new SavePictureResponse();
        String newFileName = CommonUtil.getNewRandomName(file.getOriginalFilename());
        if (CommonUtil.isRightPictureFormat(newFileName)) {
            String path = request.getSession().getServletContext().getRealPath(URL) + "/" + newFileName;
            File newFile = new File(path);
            if (newFile.exists()) {
                response.errorMsg = "文件已存在,请重命名";
            } else {
                try {
                   /* file.transferTo(newFile);*/
                    response.fileName = newFileName;
                    //上传到七牛
                    QiniuUtils qiniuUtils = new QiniuUtils();
                    boolean flag = qiniuUtils.upload(file.getBytes(), newFileName);
                    //每上传一张图片调用gc 通知有垃圾
                    System.gc();
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
    public int createQuestion(Question question, HttpServletRequest request) throws Exception {

        User user = (User)request.getSession().getAttribute("user");
        question.teacherId = user.getId();
        int i = questionService.createQuestion(question);
        if (i == 1) {
            return i;
        } else {
            throw new Exception();
        }
    }

    @RequestMapping(value = "/updateQuestion")
    @ResponseBody
    public int updateQuestion(Question question) throws Exception {

        int i = questionService.updateQuestion(question);
        if (i == 1) {
            return i;
        } else {
            throw new Exception();
        }
    }

    @RequestMapping(value = "/addToPaper")
    @ResponseBody
    public AddToPaperResponse addToPaper(int questionId, int paperId) {

        AddToPaperResponse response = new AddToPaperResponse();
        try {
            response = questionService.addToPaper(questionId, paperId);
        } catch (Exception e) {
            response.isSuccess = 0;
            response.msg = "加入试卷失败";
        }
        return response;
    }
}
