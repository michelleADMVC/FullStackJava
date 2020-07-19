package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Category;
import com.example.app.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoRepo;
	public CategoryService(CategoryRepository inject) {
		this.categoRepo = inject ; 
	}
	public List<Category> getAll(){
		return this.categoRepo.findAll();
	}
	public void saveCategory(Category category) {
		this.categoRepo.save(category);
	}
	public void newCategory(String name) {
		this.categoRepo.save(new Category(name));
	}
	public Category getCategory(Long id){
		Optional<Category> category = this.categoRepo.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		return null;
	}
	
}
