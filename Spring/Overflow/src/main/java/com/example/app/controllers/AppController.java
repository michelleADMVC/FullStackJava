package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.AnswerService;
import com.example.app.services.QuestionService;

@Controller
public class AppController {
	private QuestionService questionService;
	private AnswerService ansService;
	public AppController(QuestionService inject1, AnswerService inject2) {
		this.questionService = inject1;
		this.ansService = inject2;
	}
	
	@RequestMapping("")
	public String index(){
		return "index.html";
	}
	
	@RequestMapping("questions")
	public String getQuestions(Model model){
		model.addAttribute("questions",this.questionService.getAll());
		return "questions.html";
	}
	@RequestMapping("questions/new")
	public String getNewQuestions(Model model){
		model.addAttribute("questions",this.questionService.getAll());
		return "newQuestion.html";
	}
	@RequestMapping(value="questions/new", method = RequestMethod.POST)
	public String postNewQuestions(@RequestParam("question")String question){
		this.questionService.newQuestion(question);
		return "redirect:/questions";
	}
	@RequestMapping("questions/{id}")
	public String viewQuestion(@PathVariable("id")Long id,Model model){
		model.addAttribute("question",this.questionService.getById(id));
		return "viewQuestion.html";
	}
	@RequestMapping(value = "answer/create",method = RequestMethod.POST)
	public String newAnswer(
			@RequestParam("question_id")Long id,
			@RequestParam("answer")String answer
			){
		this.ansService.newAnswer(answer, this.questionService.getById(id));
		return "redirect:/questions/"+id;
	}
	
}
