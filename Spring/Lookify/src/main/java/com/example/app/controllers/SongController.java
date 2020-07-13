package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.models.Song;
import com.example.app.services.SongService;


@Controller
public class SongController {
	
	private SongService songService;
	public SongController(SongService inject) {
		this.songService = inject;
	}
	
	@RequestMapping("/songs/{id}")
	public String songs(Model model,@PathVariable("id")Long id) {
		model.addAttribute("song",songService.getSong(id));
		return "show";
	}
	@RequestMapping(value="/songs/delete/{id}", method = RequestMethod.POST)
	public String delete(Model model,@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/songs/new", method = RequestMethod.GET)
	public String getNewSong() {
		return "add.html";
	}
	@RequestMapping(value="/songs/new", method = RequestMethod.POST)
	public String postNewSong(@Validated @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "add.html";
		}else {
			songService.saveSong(song);
			return "redirect:/dashboard";
		}
	}
	
}
