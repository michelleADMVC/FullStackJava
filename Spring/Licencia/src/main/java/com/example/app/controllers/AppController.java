package com.example.app.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.Person;
import com.example.app.services.LicenseService;
import com.example.app.services.PersonService;

@Controller
public class AppController {
	
	private PersonService personService;
	private LicenseService licenseService;
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	
	public AppController(PersonService inject1, LicenseService inject2){
		this.personService = inject1;
		this.licenseService = inject2;
	}
	
	@RequestMapping(value="persons/new", method = RequestMethod.GET)
	public String getNewPerson(){
		return "newPerson.html";
	}
	@RequestMapping(value="persons/new", method = RequestMethod.POST)
	public String postNewPerson(
			@RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName){
		logger.info("Añadiendo persona");
		personService.newPerson(firstName, lastName);
		return "redirect:/persons/new";
	}
	
	@RequestMapping(value = "licenses/new",method = RequestMethod.GET)
	public String getNewLicense(Model model) {
		model.addAttribute("persons",personService.getAll());
		return "newLicense.html";
	}
	@RequestMapping(value = "licenses/new",method = RequestMethod.POST)
	public String postNewLicense(@RequestParam("id") Long id,
			@RequestParam("exp_date")String expDateString,
			@RequestParam("state")String state
			) throws ParseException{
		licenseService.newLicense(personService.getById(id), state, parseDate(expDateString));
		return "redirect:/licenses/new";
	}
	@RequestMapping(value = "persons/{id}")
	public String viewPerson(Model model, @PathVariable("id") Long id){
		model.addAttribute("person",personService.getById(id));
		return "person.html";
	}
	private Date parseDate(String date) throws ParseException {
		Date parsedDate= new SimpleDateFormat("yyyy-mm-dd").parse(date); 
		return parsedDate;
	}
}
