package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.ClassService;
import com.example.app.services.StudentService;

@Controller
public class ClassController {
	private ClassService classService;
	private StudentService studentService;
	
	public ClassController(ClassService inject1,StudentService inject2) {
		this.classService = inject1;
		this.studentService = inject2;
	}
	@RequestMapping("classes")
	public String getClasses(Model model){
		model.addAttribute("classes",classService.getAll());
		return"classes.html";
	}
	@RequestMapping("classes/new")
	public String newClass(){
		return"newClass.html";
	}
	@RequestMapping("classes/create")
	public String postNewClass(@RequestParam("name")String name){
		classService.newClass(name);
		return"redirect:/classes";
	}
	@RequestMapping("classes/{id}")
	public String viewClass(@PathVariable("id")Long id,Model model){
		model.addAttribute("class", this.classService.getById(id));
		return"class.html";
	}
	@RequestMapping("classes/addStudent")
	public String viewClass(
			@RequestParam("class_id")Long classId,
			@RequestParam("student_id")Long studentId){
		this.classService.addStudent(classId,this.studentService.getById(studentId));
		return"redirect:/students/"+studentId;
	}
	@RequestMapping("classes/removeStudent")
	public String removeClass(
			@RequestParam("class_id")Long classId,
			@RequestParam("student_id")Long studentId){
		this.classService.removeStudent(classId,this.studentService.getById(studentId));
		return"redirect:/students/"+studentId;
	}
}
