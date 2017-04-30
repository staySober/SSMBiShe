package com.bishe.yuanye.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.common.CommonUtil;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.entity.response.SavePictureResponse;
import com.bishe.yuanye.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Value("${imageUrl}")
    private String imageUrl;

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
        String fileName = file.getOriginalFilename();
        if (CommonUtil.isRightPictureFormat(fileName)) {
            String path = request.getSession().getServletContext().getRealPath(imageUrl) + "/" + fileName;
            File newFile = new File(path);
            if (newFile.exists()) {
                response.errorMsg = "文件已存在,请重命名";
            } else {
                try {
                    file.transferTo(newFile);
                    response.fileName = fileName;
                } catch (Exception e) {
                    response.errorMsg = "文件保存失败";
                }
            }
        } else {
            response.errorMsg = "文件格式错误";
        }
        return response;
    }


}
