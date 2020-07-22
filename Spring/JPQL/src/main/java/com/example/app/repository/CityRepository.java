package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.City;
import com.example.app.models.Country;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findAll();
	
   
}
