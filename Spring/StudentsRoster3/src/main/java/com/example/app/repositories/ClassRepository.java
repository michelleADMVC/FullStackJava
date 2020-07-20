package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long>  {
	List<Class>findAll();
}
