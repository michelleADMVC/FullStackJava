package com.example.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.Student;
import com.example.app.services.ContactService;
import com.example.app.services.StudentService;

@Controller
public class ContactController {
	private ContactService contactService;
	private StudentService studentService;
	
	
	public ContactController(ContactService inject1, StudentService inject2){
		this.contactService = inject1;
		this.studentService = inject2;
	}
	
	@RequestMapping(value="/contacts/new", method = RequestMethod.GET)
	public String getNewContact(Model model){
		model.addAttribute("students",contactService.getAvailableStudents(studentService.getAll()));
		return"newContact.html";
	}
	@RequestMapping(value="/contacts/create", method = RequestMethod.GET)
	public String postNewContact(
			@RequestParam("student")Long id,
			@RequestParam("address")String address,
			@RequestParam("city")String city,
			@RequestParam("state")String state){
		this.contactService.newContact(studentService.getById(id), address, city, state);
		return"redirect:/students";
	}
}
