package com.bishe.yuanye.controller;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentAnswerMapDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sober on 2017/4/13.
 */
@Controller
@RequestMapping(value = "/bishe")
public class pageController {

	/**
	 * 获取试卷集的方法
	 */



	@RequestMapping(value = "/getPaperList",method = RequestMethod.GET)
	public ModelAndView getPaperList(ModelAndView modelAndView, HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		//通过studentId 找到对应teacherId
		//通过teacherId 找到对应paperId
		//通过student_papaer_map 判断是否已答题该试卷
		//结果集封装
		return modelAndView;
	}


}
