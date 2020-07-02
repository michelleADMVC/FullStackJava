package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoController {
	
	@RequestMapping("/dojo")
	public String home(){
		return "¡El dojo es increible!";
	}
	@RequestMapping("/burbank-dojo")
	public String burbank(){
		return "¡El Dojo Burbank está localizado al sur de California!";
	}
	@RequestMapping("/san-jose")
	public String jose(){
		return "¡El Dojo SJ es el cuartel general!";
	}
}
