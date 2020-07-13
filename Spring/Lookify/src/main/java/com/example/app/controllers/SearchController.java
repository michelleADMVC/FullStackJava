package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.services.SongService;

@Controller
public class SearchController {
	private SongService songService;
	public SearchController(SongService inject) {
		this.songService = inject;
	}
	
	@RequestMapping("search/topTen")
	public String topTen(Model model){
		model.addAttribute("songs",songService.getTopTen());
		return "top.html";	
	}
	@RequestMapping("search")
	public String search(Model model,@RequestParam("keyword")String keyword){
		model.addAttribute("keyword", keyword);
		System.out.println("Buscando : "+keyword);
		model.addAttribute("songs", songService.getSongsByArtist(keyword));
		return"searchResults.html";
	}
		
	
}
