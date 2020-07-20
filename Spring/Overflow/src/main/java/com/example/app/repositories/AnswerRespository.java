package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Answer;
@Repository
public interface AnswerRespository extends CrudRepository<Answer, Long>{
	public List<Answer> findAll();

}
