package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.*;
import com.example.demo.models.*;
import java.util.List;

@RestController
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("")
	public String home() {
		return "crudTest";
	}
	@RequestMapping("/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable("id") long id){
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") long id){
		userService.deleteById(id);
		return "User deleted";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String postUser(
			@RequestParam("name") String name, @RequestParam("last_name") String lastName,
			@RequestParam("pass") String password,@RequestParam("email") String email
			){
		userService.newUser(name, lastName, password, email);
		return "User "+name+" saved";
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public String updateUser(
			@PathVariable("id") Long id,
			@RequestParam("name") String name, @RequestParam("last_name") String lastName,
			@RequestParam("pass") String password,@RequestParam("email") String email
			){
		userService.updateUser(id, name, lastName, password, email);
		return "User "+name+" updated";
	}
	
	@RequestMapping("test")
	public String test() {
		userService.test();
		return "Se creado un usuario de test en la base de datos";
	}
	
}
