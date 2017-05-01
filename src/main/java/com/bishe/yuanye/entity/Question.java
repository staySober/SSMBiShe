package com.bishe.yuanye.entity;

import java.io.Serializable;

/**
 * Created by yuanye on 2017/3/18.
 */
public class Question implements Serializable{

    public int id;

    public int chapterId;

    public String keywordOne;

    public String keywordTwo;

    public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
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

    public String questionText;

    public String picOneUrl;

    public String picTwoUrl;

    public String answer;

    public int teacherId;
    
}
