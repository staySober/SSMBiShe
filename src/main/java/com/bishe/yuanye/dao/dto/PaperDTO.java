package com.bishe.yuanye.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class PaperDTO implements Serializable {
    private Integer id;

    private String name;

    private Integer teacherId;

    private Date createdAt;

    private Short isShared;

    private Short isVisible;

    private Short isDeleted;

    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Short getIsShared() {
        return isShared;
    }

    public void setIsShared(Short isShared) {
        this.isShared = isShared;
    }

    public Short getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Short isVisible) {
        this.isVisible = isVisible;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }
}