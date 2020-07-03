package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			int count = (int)session.getAttribute("count") + 1;
			session.setAttribute("count",count );
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counterParam(HttpSession session, Model model,@RequestParam(value="action", required = false )String action) {
		if (action != null) {
			session.setAttribute("count",0 );
			return "redirect:/counter";
		}
		model.addAttribute("count",session.getAttribute("count"));
		return "counter.jsp";
	
	}
}
