package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.app.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	public List<Product> findAll();
	
}
