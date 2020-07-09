package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
}
