package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Comment;
import com.example.app.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findAll();
	public User findByEmail(String email);
	
}
