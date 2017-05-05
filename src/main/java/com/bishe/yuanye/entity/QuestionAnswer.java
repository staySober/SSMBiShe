package com.bishe.yuanye.entity;

/**
 * Created by Renhai on 2017/4/27.
 */
public class QuestionAnswer {

    private Integer qeustionId;
    private Question question;

    private String studentAnswer;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {

        this.studentAnswer = studentAnswer;
    }

    public Integer getQeustionId() {
        return qeustionId;
    }

    public void setQeustionId(Integer qeustionId) {
        this.qeustionId = qeustionId;
    }
}
