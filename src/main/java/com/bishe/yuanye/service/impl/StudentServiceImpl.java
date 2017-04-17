package com.bishe.yuanye.service.impl;

import java.util.List;

import com.bishe.yuanye.dao.dto.StudentDTO;
import com.bishe.yuanye.dao.dto.StudentDTOExample;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import com.bishe.yuanye.service.StudentService;
import org.apache.commons.collections.CollectionUtils;
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
}
