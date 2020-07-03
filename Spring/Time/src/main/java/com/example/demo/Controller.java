package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
	 
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("dojoName", "Test desde template time ");
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String time(Model model) {
		model.addAttribute("data", TimeService.getDate());
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String date(Model model) {
		model.addAttribute("data", TimeService.getTime());
		return "time.jsp";
	}
}
