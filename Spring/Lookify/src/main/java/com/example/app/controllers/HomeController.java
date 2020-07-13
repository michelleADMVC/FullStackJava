package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.services.SongService;

@Controller
public class HomeController {
	private SongService songService;
	public HomeController(SongService inject) {
		this.songService = inject;
	}
	@RequestMapping("")
	public String home(){
		return "index.html";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model){
		model.addAttribute("songs",songService.getAllSongs());
		return "dashboard.html";
	}
	@RequestMapping("/test")
	public String test(){
		songService.test();
		System.out.println("Test Ejecutado");
		return "redirect:/dashboard";
	}
}
