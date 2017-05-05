package com.bishe.yuanye.entity;

/**
 * Created by sober on 2017/4/13.
 */
public class Paper {

	private int id;

	private String paperName;

	private int studentId;

	private int paperId;

	private boolean isAnswer;

	private String teacherName;

	private int teacherId;

	private int isShared;

	private int isVisible;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public boolean isAnswer() {
		return isAnswer;
	}

	public void setAnswer(boolean answer) {
		isAnswer = answer;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getIsShared() {
		return isShared;
	}

	public void setIsShared(int isShared) {
		this.isShared = isShared;
	}

	public int getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}
}
