package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.ClassService;
import com.example.app.services.ContactService;
import com.example.app.services.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;
	private ClassService classService;
	
	public StudentController(StudentService inject1,ClassService inject2){
		this.studentService = inject1;
		this.classService = inject2;
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
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.GET)
	public String viewStudent(Model model,@PathVariable("id")Long id){
		model.addAttribute("availableClasses",this.classService.getAll());
		model.addAttribute("student",this.studentService.getById(id));
		return"student.html";
	}
}
