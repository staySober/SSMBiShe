package com.bishe.yuanye.service;

import java.util.List;

import com.bishe.yuanye.entity.Class;
import com.bishe.yuanye.entity.Student;
import com.bishe.yuanye.entity.Teacher;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */

public interface StudentService {

     Integer getTeacherIdByStudentId(Integer studentId);

    Student getStudentInfo(Integer id);

    List<Class> getAllClass();

    List<Teacher> getAllTeacher();

    void updateInfo(String username, Integer id, String name, String password, Integer stClass, Integer studentNum,
                    Integer teacher);

    List<Student> getAllStudent();

    void delStudent(Integer studentId);
}
