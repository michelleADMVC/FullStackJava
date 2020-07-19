package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.ContactService;
import com.example.app.services.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService inject){
		this.studentService = inject;
	}
	
	@RequestMapping(value="/students/new", method = RequestMethod.GET)
	public String getNewStudent(){
		return"newStudent.html";
	}
	@RequestMapping(value = "/students/create", method = RequestMethod.GET)
	public String postNewStudent(@RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName,
			@RequestParam("age")int age
			){
		studentService.newStudent(firstName, lastName, age);
		return "redirect:/contacts/new";
	}
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public String getStudents(Model model){
		model.addAttribute("students",studentService.getAll());
		return "students.html";
	}
}
