package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	public List<Comment> findAll();
}
