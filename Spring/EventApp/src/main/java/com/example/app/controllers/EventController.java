package com.example.app.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.User;
import com.example.app.services.EventService;
import com.example.app.services.LocationService;
import com.example.app.services.SessionService;
import com.example.app.services.UserService;

@Controller
public class EventController {
	@Autowired
	private EventService eventService;
	private LocationService locationService;
	
	
	public EventController(EventService inject1, LocationService inject2) {
		this.eventService = inject1;
		this.locationService = inject2;
	}
	@RequestMapping("events")
	public String events(HttpSession session, Model model) {
		if (SessionService.isLogged(session)) {
			model.addAttribute("user", session.getAttribute("user"));
			return "events.html";
		}else {
			return "redirect:/login";
		}
		
	}
	@RequestMapping(value = "events/create", method =  RequestMethod.POST)
	public String createEvent(
			@RequestParam ("name")String title,
			@RequestParam ("date")String date,
			@RequestParam ("location_address")String address,
			@RequestParam ("location_state")String state,
			HttpSession session
			) throws ParseException{
		User host = (User)session.getAttribute("user");
		eventService.newEvent(host, this.locationService.newLocation(address, state), title, date);
		return "redirect:/events";
		
		  
	}
}
