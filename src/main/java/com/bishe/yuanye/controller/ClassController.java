package com.bishe.yuanye.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.entity.Class;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sober on 2017/5/8.
 *
 * @author sober
 * @date 2017/05/08
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping("/getMyClass")
    @ResponseBody
    public List<Class> getMyClass(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Integer teacherId = user.getId();
        List<Class> classList = classService.getMyClass(teacherId);
        return classList;
    }
}
