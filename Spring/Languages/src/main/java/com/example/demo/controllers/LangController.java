package com.example.demo.controllers;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.LanguageService;

@Controller
public class LangController {
	LanguageService langService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LangController.class); 
	
	public LangController(LanguageService inject) {
		this.langService = inject;
	}
	
	@RequestMapping("")
	public String homeTest(Model model){
		model.addAttribute("lang", "Java");
		return "index.html";
	}
	@RequestMapping("test")
	public String index(Model model) {
		langService.test();
		model.addAttribute("test", "test languages added");
		return "index.html";
	}
	
	@RequestMapping(value = "languages", method = RequestMethod.GET)
	public String getLanguages(Model model) {
		model.addAttribute("langs", langService.getAll());
		return "languages.html";
	}
	@RequestMapping(value = "languages/{id}", method = RequestMethod.GET)
	public String getLanguage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("lang", langService.getLanguage(id));
		return "show.html";
	}
	@RequestMapping(value = "languages/edit/{id}", method = RequestMethod.GET)
	public String getEditLanguage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("lang", langService.getLanguage(id));
		return "edit.html";
	}
	@RequestMapping(value = "languages/edit", method = RequestMethod.POST)
	public String postEditLanguage(
			@RequestParam ("name") String name,
			@RequestParam ("creator") String creator,
			@RequestParam ("currentVersion") String version, 
			@RequestParam("id") Long id) {
			langService.updateLanguage(id, name, creator, version);
		return "redirect:/languages";
	}
	@RequestMapping(value = "languages", method = RequestMethod.POST)
	public String postLanguages(
			@RequestParam("action") String action, 
			@RequestParam(value = "id",required = false) Long id,
			@RequestParam (value = "name", required = false) String name,
			@RequestParam (value= "creator",required=false) String creator,
			@RequestParam (value= "currentVersion",required=false) String version){
		
		if (action.equals("add_language")) {
			if (name!=null && creator !=null && version!=null) {
				langService.newLanguage(name, creator, version);
			}	
		}
		if (action.equals("delete") && id != null) {
			langService.deleteById(id);
		}
		
		logger.info(action+" request");
		return "redirect:/languages";
	}
	
	
}
