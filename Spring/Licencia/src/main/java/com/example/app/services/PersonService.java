package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Person;
import com.example.app.repositories.PersonRepository;

@Service
public class PersonService { 
	private PersonRepository personRepo;
	public PersonService(PersonRepository inject) {
		this.personRepo = inject;
	}
	public List<Person> getAll(){
		return this.personRepo.findAll();
	}
	public void savePerson(Person person) {
		this.personRepo.save(person);
	}
	
	public void newPerson(String firstName, String lastName){
		this.savePerson(new Person(firstName,lastName));
	}
	public void test(){
		
	}
	public Person getById(Long id){
		Optional<Person> person = this.personRepo.findById(id);
		if (person.isPresent()) {
			return person.get();
		}else{
		return null;
		}
	}
}
