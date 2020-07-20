package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Question;
import com.example.app.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepo;
	public QuestionService(QuestionRepository inject) {
		this.questionRepo = inject;
	}
	public void newQuestion(String question){
		this.questionRepo.save(new Question(question));
	}
	public List<Question> getAll(){
		return this.questionRepo.findAll();
	}
	public Question getById(Long id){
		Optional<Question> newQuestion = this.questionRepo.findById(id);
		if (newQuestion.isPresent()) {
			return newQuestion.get();
		}else {
			return null;
		}
	}
}
