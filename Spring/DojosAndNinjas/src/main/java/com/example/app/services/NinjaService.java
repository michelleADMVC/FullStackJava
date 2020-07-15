package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Dojo;
import com.example.app.models.Ninja;
import com.example.app.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepo;
	public NinjaService(NinjaRepository inject) {
		this.ninjaRepo = inject;
	}
	public List<Ninja> getAll(){
		return this.ninjaRepo.findAll();
	}
	public Ninja getById(Long id) {
		Optional<Ninja> ninja = this.ninjaRepo.findById(id);
		if (ninja.isPresent()) {
			return ninja.get();
		}
		return null;
	}
	public void saveNinja(Ninja ninja) {
		this.ninjaRepo.save(ninja);
	}
	public void newNinja(Dojo dojo,String firstName,String lastName, int age) {
		this.saveNinja(new Ninja(dojo,firstName, lastName, age));
	}
}
