package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.UserData;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping("")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userData")==  null) {
			session.setAttribute("userData", new UserData());
		}
		model.addAttribute("userData",session.getAttribute("userData"));
		return "index.jsp";
	}
	@RequestMapping(value ="/gold",method = RequestMethod.POST)
	public String gold(@RequestParam(value= "action") String action, HttpSession session) {
		actionHandler(action, session);
		return "redirect:/";
	}
	private void actionHandler(String action, HttpSession session) {
		UserData data = (UserData)session.getAttribute("userData");
		if (action.equals("farm")) {
			data.perfomFarm();
		}
		if (action.equals("cave")) {
			data.perfomCave();
		}
		if (action.equals("house")) {
			data.perfomHouse();
		}
		if (action.equals("casino")) {
			data.perfomCasino();
		}
		if (action.equals("reset")) {
			data = new UserData();
		}
		session.setAttribute("userData", data);
	}
}
