package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	public List<Student> findAll();
}
