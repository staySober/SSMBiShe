package com.bishe.yuanye.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class QuestionDTO implements Serializable {
    private Integer id;

    private Integer chapterId;

    private String chapterName;

    private String keywordOne;

    private String keywordTwo;

    private String type;

    private String picOneUrl;

    private String picTwoUrl;

    private String answer;

    private Integer teacherId;

    private Date createdAt;

    private Short isDeleted;

    private String questionText;

    private String teacherName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getKeywordOne() {
        return keywordOne;
    }

    public void setKeywordOne(String keywordOne) {
        this.keywordOne = keywordOne == null ? null : keywordOne.trim();
    }

    public String getKeywordTwo() {
        return keywordTwo;
    }

    public void setKeywordTwo(String keywordTwo) {
        this.keywordTwo = keywordTwo == null ? null : keywordTwo.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPicOneUrl() {
        return picOneUrl;
    }

    public void setPicOneUrl(String picOneUrl) {
        this.picOneUrl = picOneUrl == null ? null : picOneUrl.trim();
    }

    public String getPicTwoUrl() {
        return picTwoUrl;
    }

    public void setPicTwoUrl(String picTwoUrl) {
        this.picTwoUrl = picTwoUrl == null ? null : picTwoUrl.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText == null ? null : questionText.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}