package com.bishe.yuanye.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentAnswerMapDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.service.PaperService;
import com.bishe.yuanye.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sober on 2017/4/13.
 */
@Controller
@RequestMapping(value = "/paper")
public class PageController {

	@Autowired
	private PaperService paperService;

	@Autowired
	private StudentService studentService;


	/**
	 * 获取试卷集的方法
	 */
	@ResponseBody
	@RequestMapping(value = "/getPaperList")
	public List<Paper> getPaperList(HttpServletRequest request) {
		Integer studentId = Integer.valueOf(request.getParameter("studentId"));
		//通过studentId 找到对应teacherId
		Integer teacherId = studentService.getTeacherIdByStudentId(studentId);
		//通过teacherId 找到对应paperId
		List<PaperDTO> paperDTOList = paperService.getPaperByTeacherId(teacherId);
		//通过student_answer_map 判断是否已答题该试卷
		List<StudentAnswerMapDTO> answerMapDTOS = paperService.getStudentAnswerRelation(studentId);
		//结果集封装
		List<Paper> paperList = paperDTOList.stream().map(x -> {
				Paper paper = new Paper();
				paper.setId(x.getId());
				paper.setPaperName(x.getName());
				paper.setPaperId(x.getId());
				paper.setStudentId(studentId);
				return paper;
			}
		).collect(Collectors.toList());

		paperList.forEach(paper->{
			answerMapDTOS.forEach(y->{
				if (paper.getPaperId() == y.getPaperId()){
					paper.setAnswer(true);
				}
			});
		});
		return paperList;
	}


}
