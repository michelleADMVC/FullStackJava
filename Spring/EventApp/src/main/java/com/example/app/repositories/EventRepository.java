package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	public List<Event> findAll();
}
