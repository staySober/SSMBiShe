package com.bishe.yuanye.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.entity.Class;
import com.bishe.yuanye.entity.Student;
import com.bishe.yuanye.entity.Teacher;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sober on 2017/4/27.
 *
 * @author sober
 * @date 2017/04/27
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private StudentService studentService;


    @RequestMapping("/getStudentInfo")
    @ResponseBody
    public Student getStudentInfo(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Student student = studentService.getStudentInfo(user.getId());
        return student;
    }

    @RequestMapping("/getAllClass")
    @ResponseBody
    public List<Class> getAllClass(){
       return studentService.getAllClass();
    }

    @RequestMapping("/getAllTeacher")
    @ResponseBody
    public List<Teacher> getAllTeacher(){
       return studentService.getAllTeacher();
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(String username,Integer studentId,String name,String password,Integer stClass,Integer studentNum,Integer teacher){
        studentService.updateInfo(username,studentId,name,password,stClass,studentNum,teacher);
        return "redirect:/html/student/managerinfo.html";
    }
}
