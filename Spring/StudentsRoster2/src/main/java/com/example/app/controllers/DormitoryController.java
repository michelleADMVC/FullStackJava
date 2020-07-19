package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.DormitoryService;
import com.example.app.services.StudentService;

@Controller
public class DormitoryController {
	private StudentService studentService;
	private DormitoryService dormService;
	public DormitoryController(StudentService inject1, DormitoryService inject2) {
		this.studentService = inject1;
		this.dormService = inject2;
	}
	
	@RequestMapping("/dorms/new")
	String getNewDorm(){
		return "newDormitory";
	}
	
	@RequestMapping("/dorms/create")
	String postNewDorm(@RequestParam("name")String name){
		this.dormService.newDormitory(name);
		return "redirect:/dorms";
	}
	@RequestMapping("/dorms/{id}")
	String getDorm(@PathVariable("id")Long id, Model model){
		if (this.dormService.getById(id) != null) {
			model.addAttribute("dormitoryName",this.dormService.getById(id).getName());
			model.addAttribute("dormitoryId",this.dormService.getById(id).getId());
			model.addAttribute("dormitoryStudents",this.dormService.getStudentsDormitory(id));
			model.addAttribute("availableStudents",this.dormService.getAvailableStudents(studentService.getAll()));
		}else {
			model.addAttribute("dormitoryName",null);
		}
		return "dormitory.html";
	}
	@RequestMapping("/dorms/add")
	String postNewDorm(@RequestParam("id")Long dormId,@RequestParam("student")Long studentId){
		studentService.addDormitoryToStudent(this.dormService.getById(dormId), studentId);;
		return "redirect:/dorms/"+dormId;
	}
	@RequestMapping("/dorms/removeStudent")
	String removeStudentDorm(@RequestParam("id")Long dormId,@RequestParam("student")Long studentId){
		studentService.removeDormitoryStudent(studentService.getById(studentId));
		return "redirect:/dorms/"+dormId;
	}
	@RequestMapping("/dorms")
	String dorms(Model model){
		model.addAttribute("dormitories",dormService.getAll());
		return "dormitories.html";
	}
}
