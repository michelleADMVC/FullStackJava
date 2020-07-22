package com.example.app.services;

import org.springframework.stereotype.Service;

import com.example.app.repository.CityRepository;

@Service
public class CityService {
	private CityRepository cityRepo;
	public CityService(CityRepository inject) {
		this.cityRepo = inject;
	}
	public void test() {
		
	}
}
