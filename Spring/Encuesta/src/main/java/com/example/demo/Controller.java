package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Survey;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping("")
	public String index(Model model) {
		
		return "index.jsp";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String resultsPost(@RequestParam(value= "name") String name, @RequestParam(value="location")
	String location, @RequestParam (value="favLenguage") String favLenguage, @RequestParam(value="comment",required = false)
	String comment, HttpSession session)
	{ 	
		Survey newSurvey = new Survey(name,location,favLenguage,comment);
		session.setAttribute("survey", newSurvey);
		newSurvey.showResults();
		return "redirect:/results";
	}
	@RequestMapping("/results")
	public String resultsGet(Model model,HttpSession session) {
		if (session.getAttribute("survey") != null) {
			Survey sessionSurvey = (Survey)session.getAttribute("survey");
			model.addAttribute("survey", sessionSurvey);
			return "results.jsp";
		}else {
			return "redirect:/";
		}
	}
	
}
