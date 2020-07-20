package com.example.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	private String question;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    List<Answer> answers;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "tags_questions", 
	    joinColumns = @JoinColumn(name = "question_id"), 
	    inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private List<Tag> tags;
	public Question() {}
	public Question(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public String getQuestion() {
		return question;
	}
	public Long getId() {
		return id;
	}
	public List<Tag> getTags() {
		return tags;
	}
	
}
