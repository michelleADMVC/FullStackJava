package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.demo.models.Language;
@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	public List<Language> findAll();
}
