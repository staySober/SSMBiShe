package com.bishe.yuanye.controller;

import com.bishe.yuanye.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sober on 2017/4/13.
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/bishe/login" ,method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,ModelAndView modelAndView){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer type = Integer.valueOf(request.getParameter("type"));
		//根据type 查询数据库 比对数据
		if (User.Type.getType(type) == User.Type.Student){

		}
		if (User.Type.getType(type) == User.Type.Admin){

		}
		//往session设置user信息
		//返回视图
		return modelAndView;
	}
}
