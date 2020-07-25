package com.example.app.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.User;
import com.example.app.services.UserService;

@Controller	
public class AppController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model, HttpSession session){
		if(session.getAttribute("user")!= null) {
			model.addAttribute("user", session.getAttribute("user"));
			return "home.html";
		}else {
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(value = "close_session", method = RequestMethod.GET)
	public String close(HttpSession session){
		session.setAttribute("user", null);
		return "redirect:login";
	}
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(){
		return "login.html";
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(
			HttpSession session,
			@RequestParam("email")String email,
			@RequestParam("password")String password){
		if (userService.authenticateUser(email, password)) {
			session.setAttribute("user", this.userService.findByEmail(email));
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
		
	}
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String newUser(){
		return "newUser.html";
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String postnewUser(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("passwordConfirmation") String passwordConfirmation,
			HttpSession session){
		
		if (password.equals(passwordConfirmation)) {
			
			userService.registerUser(userService.newUser(firstName, lastName, email, password));
			session.setAttribute("user",userService.findByEmail(email));
		return "redirect:/";
		}else {
		return "redirect:/register";
		}
	}
}
