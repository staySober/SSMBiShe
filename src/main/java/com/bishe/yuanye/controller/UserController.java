package com.bishe.yuanye.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bishe.yuanye.entity.Class;
import com.bishe.yuanye.entity.Student;
import com.bishe.yuanye.entity.Teacher;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.service.LoginService;
import com.bishe.yuanye.service.StudentService;
import com.bishe.yuanye.service.TeacherService;
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

    @Autowired
    private LoginService loginService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getStudentInfo")
    @ResponseBody
    public Student getStudentInfo(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Student student = studentService.getStudentInfo(user.getId());
        return student;
    }

    @RequestMapping("/getAllStudentInfo")
    @ResponseBody
    public List<Student> getAllStudentInfo(HttpServletRequest request){
        return studentService.getAllStudent();
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
    public String updateInfo(String username,Integer studentId,String name,String password,Integer stClass,Integer studentNum,Integer teacher,HttpServletRequest request){
        studentService.updateInfo(username,studentId,name,password,stClass,studentNum,teacher);
        //刷新 session
        User user = new User();
        user.setUserType(User.Type.STUDENT.value());
        user.setUsername(username);
        user.setPassword(password);
        User loginUser = loginService.Login(user);
        if (loginUser != null){
            request.getSession().setAttribute("user",loginUser);
        }
        return "redirect:/html/student/managerinfo.html";
    }


    /**
     * 超级管理员的api
     */
    @RequestMapping("/updateInfoSuper")
    public String updateInfoSuper(String username,Integer studentId,String name,String password,Integer stClass,Integer studentNum,Integer teacher,HttpServletRequest request){
        studentService.updateInfo(username,studentId,name,password,stClass,studentNum,teacher);
        //不刷新 session
        return "redirect:/html/student/accountstudent.html";
    }

    @RequestMapping("/delUser")
    public String delUser(Integer studentId){
        studentService.delStudent(studentId);
        return "success";
    }

    @RequestMapping("/delTeacher")
    public String delTeacher(Integer teacherId){
        teacherService.delTeacher(teacherId);
        return "success";
    }
}
