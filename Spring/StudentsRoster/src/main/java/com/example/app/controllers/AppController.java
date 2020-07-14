package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.ContactService;
import com.example.app.services.StudentService;

@Controller
public class AppController {
	private ContactService contactService;
	private StudentService studentService;
	
	public AppController(ContactService inject1, StudentService inject2){
		this.contactService = inject1;
		this.studentService = inject2;
	}
	
	@RequestMapping(value="/students/new", method = RequestMethod.GET)
	public String getNewStudent(){
		return"newStudent.html";
	}
	@RequestMapping(value = "/students/new", method = RequestMethod.POST)
	public String postNewStudent(@RequestParam("first_name")String firstName,
			@RequestParam("last_name")String lastName,
			@RequestParam("age")int age
			){
		studentService.newStudent(firstName, lastName, age);
		return "redirect:/contacts/new";
	}
	@RequestMapping(value="/contacts/new", method = RequestMethod.GET)
	public String getNewContact(Model model){
		model.addAttribute("students",studentService.getAll());
		return"newContact.html";
	}
	@RequestMapping(value="/contacts/new", method = RequestMethod.POST)
	public String postNewContact(
			@RequestParam("id")Long id,
			@RequestParam("address")String address,
			@RequestParam("city")String city,
			@RequestParam("state")String state){
		this.contactService.newContact(studentService.getById(id), address, city, state);
		return"redirect:/students";
	}
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public String getStudents(Model model){
		model.addAttribute("students",studentService.getAll());
		return "students.html";
	}
}
