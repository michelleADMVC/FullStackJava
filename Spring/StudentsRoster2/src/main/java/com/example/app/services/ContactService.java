package com.example.app.services;

import java.util.ArrayList;
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
	public List<Student> getAvailableStudents(List<Student> students){
		List<Student> availableStudents = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getContact() == null) {
				System.out.println(students.get(i).getFirstName()+" dont have have a contact");
				availableStudents.add(students.get(i));
			
			}else {
				System.out.println(students.get(i).getFirstName()+" have contact ");
				
			}
		}
		
		return availableStudents;
	}
}
