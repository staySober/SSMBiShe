package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.dao.dto.StudentDTO;
import com.bishe.yuanye.dao.dto.StudentDTOExample;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import com.bishe.yuanye.service.StudentService;
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

    @Override
    public Integer getTeacherIdByStudentId(Integer studentId) {
        StudentDTO studentDTO = studentMapper.selectByPrimaryKey(studentId);
        if (studentDTO.getId() != null){
            return studentDTO.getId();
        }
        return null;
    }
}
