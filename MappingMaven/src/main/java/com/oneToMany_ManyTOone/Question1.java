package com.oneToMany_ManyTOone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question1 {
	@Id
	@Column(name="ques_id")
	private int quesid;
	private String questions;
	@OneToMany(mappedBy="qus")
	private List<Answer1> answers;
	public Question1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question1(int quesid, String questions, List<Answer1> answers) {
		super();
		this.quesid = quesid;
		this.questions = questions;
		this.answers = answers;
	}

	public int getQuesid() {
		return quesid;
	}
	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public List<Answer1> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer1> answers) {
		this.answers = answers;
	}
	
	
	
}
