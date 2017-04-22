package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login(User user, HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView){
		if (user == null){
			modelAndView.setViewName("redirect:/html/errorLogin.html");
		}

		User loginUser = loginService.Login(user);
		if (loginUser != null ){
		//往session设置user信息
			request.getSession().setAttribute("user",loginUser);
			if (User.Type.getType(user.getUserType()) == User.Type.STUDENT){
				modelAndView.setViewName("redirect:/html/student/studenthome.html");
			}
			if (User.Type.getType(user.getUserType()) == User.Type.TEACHER){
				modelAndView.setViewName("redirect:/html/student/teacherboard.html");
			}
		}else {
			modelAndView.setViewName("redirect:/html/errorLogin.html");
		}
		//返回视图
		return modelAndView;
	}
}
