package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	public List<Tag> findAll();
}
