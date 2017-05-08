package com.bishe.yuanye.service;

import java.util.List;

import com.bishe.yuanye.entity.Class;

/**
 * Created by sober on 2017/5/8.
 *
 * @author sober
 * @date 2017/05/08
 */
public interface ClassService {

    List<Class> getMyClass(Integer teacherId);
}
