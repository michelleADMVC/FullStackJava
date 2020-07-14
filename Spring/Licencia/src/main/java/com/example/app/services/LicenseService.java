package com.example.app.services;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.models.License;
import com.example.app.models.Person;
import com.example.app.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepo;
	private String lastLicenseNumber;
	public LicenseService(LicenseRepository inject){
		this.licenseRepo = inject;
		this.lastLicenseNumber = getLicenseNumber();
	}
	public void saveLicense(License license){
		this.licenseRepo.save(license);
	}
	public List<License> getAll(){
		return this.licenseRepo.findAll();
	}
	public void newLicense(Person person, String state, Date expDate){
		if(person!=null) {
			License newLicense = new License(this.lastLicenseNumber,expDate,state,person);
			this.saveLicense(newLicense);
		}else {
			System.out.println("Not valid person to new license");
		}
		
	}
	
	public String getLicenseNumber() {
		int zeros = 6;
		int totalLicenses = this.getAll().size();
		//Not ready
		return "0000001";
	}
}
