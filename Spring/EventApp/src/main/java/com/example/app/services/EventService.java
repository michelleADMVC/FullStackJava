package com.example.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.app.models.Event;
import com.example.app.models.Location;
import com.example.app.models.User;
import com.example.app.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepo;
	public EventService(EventRepository inject) {
		this.eventRepo = inject;
	}
	
	public void saveEvent(Event event) {
		this.eventRepo.save(event);
	}
	
	public void newEvent(User user,Location location, String title, String date ) throws ParseException{
		System.out.println("new event at date "+parseStringToDate(date).toString());
//		new Event(user, location, title, date);
	}
	public Date parseStringToDate(String date) throws ParseException {
		
		  return new SimpleDateFormat("dd-MM-yyyy").parse(date);  
	}
}
