package com.bishe.yuanye.service.impl;

import java.util.List;
import java.util.stream.Collector;
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
import org.springframework.transaction.annotation.Transactional;

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
        student.setId(studentDTO.getId());
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
            t.setPassword(x.getPassword());
            return t;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void updateInfo(String username, Integer id, String name, String password, Integer stClass,
                           Integer studentNum, Integer teacher) {
        StudentDTO dto = new StudentDTO();
        dto.setId(id);
        dto.setUsername(username);
        dto.setName(name);
        dto.setPassword(password);
        dto.setClassId(stClass);
        dto.setTeacherId(teacher);
        dto.setStudentNum(studentNum);
        studentMapper.updateByPrimaryKeySelective(dto);
    }

    @Override
    public List<Student> getAllStudent() {
        StudentDTOExample example = new StudentDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0);
        List<StudentDTO> studentDTOS = studentMapper.selectByExample(example);
        List<Student> collect = studentDTOS.stream().map(x -> {
            Student student = new Student();
            student.setId(x.getId());
            student.setUsername(x.getUsername());
            student.setName(x.getName());
            student.setPassword(x.getPassword());
            student.setStudentNum(x.getStudentNum());

            ClassDTO classDTO = classMapper.selectByPrimaryKey(x.getClassId());
            student.setStClass(classDTO.getName());

            TeacherDTO teacherDTO = teacherMapper.selectByPrimaryKey(x.getTeacherId());
            student.setTeacher(teacherDTO.getName());
            return student;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void delStudent(Integer studentId) {
        StudentDTO dto = new StudentDTO();
        dto.setIsDeleted((short)1);
        dto.setId(studentId);
        studentMapper.updateByPrimaryKeySelective(dto);
    }

    @Override
    @Transactional
    public void createClassAndImportStu(String className, String majorName,Integer teacherId, List<StudentDTO> list)throws Exception {
        Integer classId = null;
        ClassDTOExample example = new ClassDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0);
        List<ClassDTO> classDTOS = classMapper.selectByExample(example);
        List<String> classNameList = classDTOS.stream().map(x -> x.getName()).collect(Collectors.toList());

        if (classNameList.contains(className)){
            throw new Exception("create Class Failed");
        }else {
            ClassDTO dtoClass = new ClassDTO();
            dtoClass.setIsDeleted((short)0);
            dtoClass.setName(className);
            dtoClass.setMajor(majorName);
            dtoClass.setTeacherId(teacherId);
            classMapper.insert(dtoClass);
            example.clear();
            example.createCriteria().andNameEqualTo(className).andIsDeletedEqualTo((short)0);
            List<ClassDTO> classDTOS1 = classMapper.selectByExample(example);
            classId = classDTOS1.get(0).getId();
        }

        for (StudentDTO dto : list) {
            try{
                dto.setClassId(classId);
                dto.setTeacherId(teacherId);
                studentMapper.insert(dto);
            }catch (Exception e){
                throw new Exception("student_num duplicate!");
            }
        }

    }
}
