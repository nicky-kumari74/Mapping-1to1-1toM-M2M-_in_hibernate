package com.oneToMany_ManyTOone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer1 {
	@Id
	@Column(name="ans_id")
	private int ansid;
	private String answer;
	@ManyToOne
	private Question1 qus;
	public Answer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer1(int ansid, String answer, Question1 qus) {
		super();
		this.ansid = ansid;
		this.answer = answer;
		this.qus= qus;
	}
	public Question1 getQus() {
		return qus;
	}
	public void setQus(Question1 qus) {
		this.qus = qus;
	}
	public int getAnsid() {
		return ansid;
	}
	public void setAnsid(int ansid) {
		this.ansid = ansid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
