package com.bishe.yuanye.entity;

import java.io.Serializable;

/**
 * Created by yuanye on 2017/3/18.
 */
public class Question implements Serializable{

    private Integer id;

    private Integer chapter;

    private String keywordOne;

    private String keywordTwo;

    private String type;

    private String questionText;

    private String picOneUrl;

    private String picTwoUrl;

    private String answer;

    private int teacherId;

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public String getKeywordOne() {
        return keywordOne;
    }

    public void setKeywordOne(String keywordOne) {
        this.keywordOne = keywordOne;
    }

    public String getKeywordTwo() {
        return keywordTwo;
    }

    public void setKeywordTwo(String keywordTwo) {
        this.keywordTwo = keywordTwo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getPicOneUrl() {
        return picOneUrl;
    }

    public void setPicOneUrl(String picOneUrl) {
        this.picOneUrl = picOneUrl;
    }

    public String getPicTwoUrl() {
        return picTwoUrl;
    }

    public void setPicTwoUrl(String picTwoUrl) {
        this.picTwoUrl = picTwoUrl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
