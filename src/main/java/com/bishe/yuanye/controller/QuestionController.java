package com.bishe.yuanye.controller;

import java.io.File;

import com.bishe.yuanye.common.CommonUtil;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
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

    @Value("imageUrl")
    private String imageUrl;

    @RequestMapping(value = "/queryQuestion")
    @ResponseBody
    public QueryQuestionResponse queryQuestion(QueryQuestionRequest request) {

        QueryQuestionResponse response = questionService.queryQuestion(request);
        return response;
    }

    @RequestMapping(value = "/savePicture")
    @ResponseBody
    public Model savePicture(@RequestParam("file") CommonsMultipartFile file, Model model) {

        String fileName = file.getOriginalFilename();
        if (CommonUtil.isRightPictureFormat(fileName)) {
            String path = imageUrl + fileName;
            File newFile = new File(path);
            if (newFile.exists()) {
                model.addAttribute("errorMsg", "文件已存在,请重命名");
            } else {
                try {
                    file.transferTo(newFile);
                    model.addAttribute("fileName", fileName);
                } catch (Exception e) {
                    model.addAttribute("errorMsg", "文件保存失败");
                }
            }
        } else {
            model.addAttribute("errorMsg", "文件格式错误");
        }
        return model;
    }
}
