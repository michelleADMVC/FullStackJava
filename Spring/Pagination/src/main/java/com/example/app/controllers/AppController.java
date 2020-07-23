package com.example.app.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.Dojo;
import com.example.app.models.Ninja;
import com.example.app.services.DojoService;
import com.example.app.services.NinjaService;
@Controller
public class AppController {
	
	private DojoService dojoService;
	private NinjaService ninjaService;
	
	public AppController(DojoService inject1, NinjaService inject2) {
		this.dojoService = inject1;
		this.ninjaService = inject2;
	}
	@RequestMapping(value = "/dojos/new", method = RequestMethod.GET)
	public String getNewDojo(){
		return "newDojo.html";
	}
	
	@RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
	public String postnewDojo(@RequestParam("name")String name){
		dojoService.newDojo(name);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.GET)
	public String getNewNinja(Model model){
		model.addAttribute("dojos",dojoService.getAll());
		return "newNinja.html";
	}
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
	public String postNewNinja(
			@RequestParam("dojo_id")Long id,
			@RequestParam("first_name")String firstName,
			@RequestParam("last_name")String lastName,
			@RequestParam("age")int age
			){
		ninjaService.newNinja(dojoService.getById(id), firstName, lastName, age);
		return "redirect:/ninjas/new";
	}
	@RequestMapping(value = "/dojos/{id}", method = RequestMethod.GET)
	public String getDojo(Model model,@PathVariable("id") Long id){
		Dojo dojo = dojoService.getById(id);
		if (dojo!=null) {
			model.addAttribute("dojoName",dojo.getName());
			model.addAttribute("ninjas",dojo.getNinjas());
		}else {
			model.addAttribute("dojoName","Dojo not found");
		}
		
		return "showDojo.html";
	}
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    //Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última página) 
	    Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
	    //Total número de páginas que tenemos
	    int totalPages = ninjas.getTotalPages();
	    int[] pages = new int[totalPages];
	    for (int i = 0; i < totalPages; i++) {
			pages[i] = i+1;
		}
	    model.addAttribute("totalPages", pages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.html";
	}
}
