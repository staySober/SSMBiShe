package com.bishe.yuanye.service;

import java.util.List;

import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.entity.response.CountInfoResponse;

/**
 * Created by sober on 2017/4/28.
 *
 * @author sober
 * @date 2017/04/28
 */
public interface TeacherService {
    void delTeacher(Integer teacherId);

    List<Paper> getTeacherPapers(int teacherId);

    CountInfoResponse getCountInfo(int teacherId);

    void updateInfo(String username, String password, String name, Integer teacherId, String telephone);
}
