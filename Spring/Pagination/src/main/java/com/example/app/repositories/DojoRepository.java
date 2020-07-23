package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	public List<Dojo> findAll();
}
