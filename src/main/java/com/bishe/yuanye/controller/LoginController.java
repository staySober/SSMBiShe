package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.entity.User.Type;
import com.bishe.yuanye.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sober on 2017/4/13.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/loginUser")
    public String login(User user, HttpServletRequest request) {
        if (user == null) {
            return "redirect:/html/errorLogin.html";
        }

        User loginUser = loginService.Login(user);
        if (loginUser != null) {
            //往session设置user信息
            request.getSession().setAttribute("user", loginUser);
            if (User.Type.getType(user.getUserType()) == User.Type.STUDENT || User.Type.getType(user.getUserType())
                == Type.ADMIN) {
                return "redirect:/html/student/studenthome.html";
            } else if (User.Type.getType(user.getUserType()) == User.Type.TEACHER) {
                return "redirect:/html/teacher/teacherIndex.html";
            } else {
                return "redirect:/html/errorLogin.html";
            }
        } else {
            return "redirect:/html/errorLogin.html";
        }
    }

    @RequestMapping(value = "/getUserSession")
    @ResponseBody
    public User getUserSession(HttpServletRequest request) {
        return (User)request.getSession().getAttribute("user");
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "/html/login";
    }
}
