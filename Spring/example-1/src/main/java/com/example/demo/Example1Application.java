package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Example1Application {

	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);
	}
	
	@RequestMapping("/")
    public String hello() { 
            return "Hola usuario, buen dia!";
    }
	@RequestMapping("/random")
    public String random() { 
            return "Spring Boot es muy interesante y rapido, podria hacerte una aplicacion en algunas horas";
    }
	
}
