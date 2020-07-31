package com.example.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.User;
import com.example.app.services.LocationService;
import com.example.app.services.SessionService;
import com.example.app.services.UserService;

@Controller
public class UserController {
	@Autowired
	private LocationService locationService;
	private UserService userService;
	
	public UserController(LocationService inject1, UserService inject2) {
		this.locationService = inject1;
		this.userService = inject2;
	}
	@RequestMapping("/login")
	public String getLogin(){
		return "login.html";
	}
	@RequestMapping("/login/logout")
	public String logout(HttpSession session){
		SessionService.unlog(session);
		return "redirect:/";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			HttpSession session
			){
		if (userService.authenticateUser(email, password)) {
			SessionService.logUser(session, userService.findByEmail(email));
			return "redirect:/events";
		}else {
			return "redirect:/login";
		}
		
		
	}
	@RequestMapping("/register")
	public String getRegister(){
		return "register.html";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(
			@RequestParam("first_name")String firstName,
			@RequestParam("last_name")String lastName,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("pass_confirmation")String passConfirmation,
			@RequestParam("location_address")String locationAddress,
			@RequestParam("location_state")String locationState,
			HttpSession session
			){
		if (password.equals(passConfirmation)) {
			if (!this.userService.userExists(email)) {
				User newUser = userService.registerUser(firstName, lastName, email, password, 
						locationService.newLocation(locationAddress, locationState));
				SessionService.logUser(session, newUser);
				return "redirect:/";
			}else {
				return "redirect:/register";
			}
		}else {
			return "redirect:/register";
		}
	}
}
