package com.example.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.services.SessionService;

@Controller
public class AppController {
	@RequestMapping("")
	public String index(HttpSession session){
		if (SessionService.isLogged(session)) {
			return "redirect:/events";
		}else {
			return "redirect:/login";
		}
		
	}
}
