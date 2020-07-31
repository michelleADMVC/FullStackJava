package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
	public List<Location> findAll();
	public List<Location> findByAddressAndState(String address,String state);
}
