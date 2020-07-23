package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Dojo;
import com.example.app.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepo;
	public DojoService(DojoRepository inject) {
		dojoRepo = inject;
	}
	public List<Dojo> getAll(){
		return this.dojoRepo.findAll();
	}
	public Dojo getById(Long id) {
		Optional<Dojo> dojo = this.dojoRepo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		}
		return null;
	}
	
	public void newDojo(String name) {
		this.saveDojo(new Dojo(name));
	}
	
	public void saveDojo(Dojo dojo){
		this.dojoRepo.save(dojo);
	}
	
}
