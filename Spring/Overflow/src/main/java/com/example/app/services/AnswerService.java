package com.example.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.models.Answer;
import com.example.app.models.Question;
import com.example.app.repositories.AnswerRespository;

@Service
public class AnswerService {
	private AnswerRespository ansRepo;
	public AnswerService(AnswerRespository inject){
		this.ansRepo = inject;
	}
	public List<Answer> getAll(){
		return this.ansRepo.findAll();
	}
	public void newAnswer(String answer, Question question){
		this.ansRepo.save(new Answer(answer,question));
	}
}
