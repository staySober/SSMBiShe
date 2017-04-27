package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by sober on 2017/4/27.
 *
 * @author sober
 * @date 2017/04/27
 */
public interface AdminMapper {

    Admin selectAdmin(@Param("username")String username,@Param("password")String password);
}
