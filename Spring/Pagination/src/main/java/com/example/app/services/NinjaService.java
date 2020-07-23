package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.models.Dojo;
import com.example.app.models.Ninja;
import com.example.app.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	private static final int PAGE_SIZE = 5;
	public Page<Ninja>ninjasPerPage(int pageNumber){
		Pageable pageRequest = PageRequest.of(pageNumber, PAGE_SIZE,Sort.by("dojo"));
        Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
        return ninjas;
		
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
