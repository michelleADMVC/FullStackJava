package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("error", "false");
		return "index.jsp";
	}
	@RequestMapping("code")
	public String code() {
		
		return "code.jsp";
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String index(@RequestParam(value="code") String code, Model model) {
		if (!code.equalsIgnoreCase("bushido")) {
			model.addAttribute("error", "true");
			return "index.jsp";
		}else {
			return "code.jsp";
		}
		
	}
}
