package com.bishe.yuanye.entity;

import java.util.Arrays;

/**
 * Created by sober on 2017/4/13.
 */
public class User {

    private Integer id;

    private Integer userType;

    private String name;

    private String username;

    private String password;

    private Integer teacherId;


    public enum Type {

        STUDENT(1),

        TEACHER(2),

        ADMIN(3);

        int _value;

        public int value() {
            return _value;
        }

        Type(int value) {
            _value = value;
        }

        public static Type getType(int _value) {
            Type[] types = Type.values();
            return Arrays.stream(types)
                .filter(type -> type.value() == _value)
                .findAny().get();
        }
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {

        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


