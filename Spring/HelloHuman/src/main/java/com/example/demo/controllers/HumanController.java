package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	
	 @RequestMapping("")
	    public String index(@RequestParam(value="name", required=false) 
	    String name) {
	        if (name != null) {
				return "Bienvenido "+name;
			}else {
				return"Saludos usuario";
			}
	        
	    }
}
