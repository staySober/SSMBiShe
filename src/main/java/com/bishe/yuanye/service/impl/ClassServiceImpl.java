package com.bishe.yuanye.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.bishe.yuanye.dao.dto.ClassDTO;
import com.bishe.yuanye.dao.dto.ClassDTOExample;
import com.bishe.yuanye.dao.mapper.ClassDTOMapper;
import com.bishe.yuanye.entity.Class;
import com.bishe.yuanye.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/5/8.
 *
 * @author sober
 * @date 2017/05/08
 */
@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassDTOMapper classMapper;

    @Override
    public List<Class> getMyClass(Integer teacherId) {
        ClassDTOExample example = new ClassDTOExample();
        example.createCriteria().andIsDeletedEqualTo((short)0).andTeacherIdEqualTo(teacherId);
        List<ClassDTO> classDTOS = classMapper.selectByExample(example);
        List<Class> collect = classDTOS.stream().map(x -> {
            Class c = new Class();
            c.setId(x.getId());
            c.setMajor(x.getMajor());
            c.setTeacherId(x.getTeacherId());
            c.setName(x.getName());
            return c;
        }).collect(Collectors.toList());
        return collect;
    }
}
