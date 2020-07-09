package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Controller
public class UserController {
private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("test", 1234);
		return "index.html";
	}
	@RequestMapping("/users")
	public String users(Model model) {
		List<User> users = userService.getAllUsers();
		
		model.addAttribute("users", users);
		return "users.html";
	}
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String postUser(@Validated @ModelAttribute("book") User user, BindingResult result){
		if (result.hasErrors()) {
            return "new_user.html";
        } else {
            userService.saveUser(user);
            return "redirect:/users";
        }
	}
	@RequestMapping("/users/new")
	public String newUser(Model model) {
		
		return "new_user.html";
	}
	@RequestMapping("/users/{id}/show")
	public String showUser(Model model, @PathVariable("id") Long id) {
		User user = userService.findById(id);
		model.addAttribute("user",user);
		return "show.html";
	}
}
