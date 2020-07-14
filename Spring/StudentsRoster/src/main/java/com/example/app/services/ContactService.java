package com.example.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.models.Contact;
import com.example.app.models.Student;
import com.example.app.repositories.ContactRepository;

@Service
public class ContactService {
	private ContactRepository contactRepo;
	public ContactService(ContactRepository inject) {
		this.contactRepo = inject;
	}
	public void saveContact(Contact contact) {
		this.contactRepo.save(contact);
	}
	public List<Contact> getAll(){
		return this.contactRepo.findAll();
	}
	public void newContact(Student student,String address,String city, String state){
		this.saveContact(new Contact(student,address,city,state));
	}
}
