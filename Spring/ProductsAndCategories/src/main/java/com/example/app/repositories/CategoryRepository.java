package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	public List<Category> findAll();
}
