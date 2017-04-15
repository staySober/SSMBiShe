package com.bishe.yuanye.entity;

/**
 * Created by sober on 2017/4/13.
 */
public class Paper {

	private int id;

	private String papaerName;

	private int studentId;

	private int paperId;

	private boolean isAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPapaerName() {
		return papaerName;
	}

	public void setPapaerName(String papaerName) {
		this.papaerName = papaerName;
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
}
