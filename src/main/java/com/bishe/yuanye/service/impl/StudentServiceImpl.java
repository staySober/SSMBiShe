package com.bishe.yuanye.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.bishe.yuanye.dao.dto.ClassDTO;
import com.bishe.yuanye.dao.dto.ClassDTOExample;
import com.bishe.yuanye.dao.dto.StudentDTO;
import com.bishe.yuanye.dao.dto.StudentDTOExample;
import com.bishe.yuanye.dao.dto.TeacherDTO;
import com.bishe.yuanye.dao.dto.TeacherDTOExample;
import com.bishe.yuanye.dao.mapper.ClassDTOMapper;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import com.bishe.yuanye.dao.mapper.TeacherDTOMapper;
import com.bishe.yuanye.entity.Class;
import com.bishe.yuanye.entity.Student;
import com.bishe.yuanye.entity.Teacher;
import com.bishe.yuanye.service.StudentService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.javassist.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
	private StudentDTOMapper studentMapper;

    @Autowired
    private ClassDTOMapper classMapper;

    @Autowired
    private TeacherDTOMapper teacherMapper;

    @Override
    public Integer getTeacherIdByStudentId(Integer studentId) {
        StudentDTOExample example = new StudentDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0).andIdEqualTo(studentId);
        List<StudentDTO> studentDTOS = studentMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(studentDTOS)){
           return studentDTOS
               .stream()
               .findAny()
               .get()
               .getId();
        }
        return null;
    }

    @Override
    public Student getStudentInfo(Integer id) {
        Student student = new Student();
        StudentDTO studentDTO = studentMapper.selectByPrimaryKey(id);
        student.setId(student.getId());
        student.setUsername(studentDTO.getUsername());
        student.setName(studentDTO.getName());
        student.setPassword(studentDTO.getPassword());
        student.setStudentNum(studentDTO.getStudentNum());

        ClassDTO classDTO = classMapper.selectByPrimaryKey(studentDTO.getClassId());
        student.setStClass(classDTO.getName());

        TeacherDTO teacherDTO = teacherMapper.selectByPrimaryKey(studentDTO.getTeacherId());
        student.setTeacher(teacherDTO.getName());
        return student;
    }

    @Override
    public List<Class> getAllClass() {
        ClassDTOExample example = new ClassDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0);
        List<ClassDTO> classDTOS = classMapper.selectByExample(example);
        List<Class> collect = classDTOS.stream().map(x -> {
            Class c = new Class();
            c.setId(x.getId());
            c.setName(x.getName());
            c.setMajor(x.getMajor());
            return c;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        TeacherDTOExample example = new TeacherDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0);
        List<TeacherDTO> teacherDTOS = teacherMapper.selectByExample(example);
        List<Teacher> collect = teacherDTOS.stream().map(x -> {
            Teacher t = new Teacher();
            t.setId(x.getId());
            t.setName(x.getName());
            t.setUsername(x.getUsername());
            t.setTelephone(x.getTelephone());
            return t;
        }).collect(Collectors.toList());
        return collect;
    }
}
