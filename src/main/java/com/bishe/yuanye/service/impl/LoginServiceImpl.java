package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.dao.dto.StudentDTO;
import com.bishe.yuanye.dao.dto.StudentDTOExample;
import com.bishe.yuanye.dao.dto.TeacherDTO;
import com.bishe.yuanye.dao.dto.TeacherDTOExample;
import com.bishe.yuanye.dao.mapper.AdminMapper;
import com.bishe.yuanye.dao.mapper.StudentDTOMapper;
import com.bishe.yuanye.dao.mapper.TeacherDTOMapper;
import com.bishe.yuanye.entity.Admin;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.entity.User.Type;
import com.bishe.yuanye.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Renhai on 2017/4/22.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    StudentDTOMapper studentDTOMapper;

    @Autowired
    TeacherDTOMapper teacherDTOMapper;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public User Login(User user) {

        //根据type 查询数据库 比对数据
        if (User.Type.getType(user.getUserType())== User.Type.STUDENT){
            StudentDTOExample example = new StudentDTOExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword()).andIsDeletedEqualTo((short)0);
            List<StudentDTO> studentDTOS = studentDTOMapper.selectByExample(example);
             return CollectionUtils.isEmpty(studentDTOS) ? null: studentDTOS.stream().map(x->{
                 User user1 = new User();
                 user1.setId(x.getId());
                 user1.setUsername(x.getUsername());
                 user1.setPassword(x.getPassword());
                 user1.setUserType(User.Type.STUDENT.value());
                 user1.setTeacherId(x.getTeacherId());
                 user1.setName(x.getName());
                 return user1;
             }).collect(Collectors.toList()).get(0);
        }
        if (user.getUserType() == User.Type.TEACHER.value()){
            TeacherDTOExample example = new TeacherDTOExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword()).andIsDeletedEqualTo((short)0);
            List<TeacherDTO> teacherDTOS = teacherDTOMapper.selectByExample(example);
            return CollectionUtils.isEmpty(teacherDTOS) ? null: teacherDTOS.stream().map(x->{
                User user1 = new User();
                user1.setUsername(x.getUsername());
                user1.setPassword(x.getPassword());
                user1.setUserType(Type.TEACHER.value());
                user1.setId(x.getId());
                user1.setName(x.getName());
                return user1;
            }).collect(Collectors.toList()).get(0);
        }

        if (user.getUserType() == Type.ADMIN.value()){
            Admin admin = adminMapper.selectAdmin(user.getUsername(), user.getPassword());
            if (admin!=null){
                User user1 = new User();
                user1.setId(admin.getId());
                user1.setPassword(admin.getPassword());
                user1.setUsername(admin.getUsername());
                user1.setName(admin.getName());
                user1.setUserType(Type.ADMIN.value());
                return user1;
            }
        }
        return null;
    }
}
