package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.dao.dto.TeacherDTO;
import com.bishe.yuanye.dao.mapper.TeacherDTOMapper;
import com.bishe.yuanye.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/4/28.
 *
 * @author sober
 * @date 2017/04/28
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDTOMapper teacherDTOMapper;

    @Override
    public void delTeacher(Integer teacherId) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacherId);
        dto.setIsDeleted((short)0);
        teacherDTOMapper.updateByPrimaryKeySelective(dto);
    }
}
