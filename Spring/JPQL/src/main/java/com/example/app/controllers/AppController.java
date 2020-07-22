package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.services.CityService;
import com.example.app.services.CountryService;

@Controller
public class AppController {
	private CityService cityService;
	private CountryService countryService; 
	public AppController(CityService inject1, CountryService inject2) {
		this.cityService = inject1;
		this.countryService = inject2;
		
	} 
	@RequestMapping("test")
	public String test(Model model){
		System.out.println("Executing test");
		countryService.surfaceLessThan501();
		return "results.html";
	}
	
}
