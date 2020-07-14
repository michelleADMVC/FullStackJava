package com.example.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Contact;
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	public List<Contact>findAll();
}
