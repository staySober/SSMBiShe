package com.bishe.yuanye.entity;

/**
 * Created by sober on 2017/4/27.
 *
 * @author sober
 * @date 2017/04/27
 */
public class Class {

    private Integer id;

    private String name;

    private String major;

    private Integer teacherId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
