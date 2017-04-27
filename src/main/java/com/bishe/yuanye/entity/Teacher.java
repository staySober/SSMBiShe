package com.bishe.yuanye.entity;

/**
 * Created by sober on 2017/4/27.
 *
 * @author sober
 * @date 2017/04/27
 */
public class Teacher {

      private Integer id;

      private String username;

      private String name;

      private String telephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
