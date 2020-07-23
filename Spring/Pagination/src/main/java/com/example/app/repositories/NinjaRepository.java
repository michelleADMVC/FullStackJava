package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja,Long>  {
	public List<Ninja> findAll();
}
