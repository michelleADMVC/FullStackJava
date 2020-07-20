package com.example.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {
	@Id
	@GeneratedValue
	private Long id;
	private String answer;
	@Column(updatable =false )
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id")
	Question question;
	public Answer(){}
	public Answer(String answer,Question question){
		this.answer = answer;
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
}
