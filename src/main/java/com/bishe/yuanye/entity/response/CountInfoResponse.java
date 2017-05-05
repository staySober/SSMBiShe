package com.bishe.yuanye.entity.response;

/**
 * Created by yuanye on 2017/5/4.
 *
 * @author yuanye
 * @date 2017/05/04
 */
public class CountInfoResponse {

    public int questionCount;

    public int paperCount;

    public int studentCount;

    public int classCount;

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }
}
