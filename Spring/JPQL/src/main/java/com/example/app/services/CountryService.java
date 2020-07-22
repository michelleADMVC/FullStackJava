package com.example.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.models.Country;
import com.example.app.repository.CountryRepository;

@Service
public class CountryService {
	private CountryRepository countryRepo;
	
	public CountryService(CountryRepository inject) {
		this.countryRepo = inject;
	}
	public void test() {
		List<Country> countries = this.countryRepo.joinCountryAndLanguages();
		for (Country countryTemp:countries) {
			System.out.println(countryTemp);
		}
	}
	public void slovenCountries() {
		List<Object[]> table = countryRepo.countriesSlovene();

		for(Object[] row : table) {
		    System.out.println("Country : " + row[0] +" Language "+ row[1]+ " Percentage : "+ row[2]);
		}
	}
	public void citiesOfMexico() {
		List<Object[]> table = this.countryRepo.citiesOfMexico();
		for(Object[] row : table) {
		    System.out.println("Country : " + row[0] +" City "+ row[1]+ " Population : "+ row[2]);
		}
		
	}
	public List<Country> numberOfcities() {
		List<Country> countries = this.countryRepo.countriesCities();
		for (Country countryTemp:countries) {
			System.out.println(countryTemp);
		}
		return countries;
	}
	public void languagesMoreThan() {
		List<Object[]> table = this.countryRepo.languagesMoreThan();
		for(Object[] row : table) {
		    System.out.println("Country : " + row[0] +" Language "+ row[1]+ " Percentage : "+ row[2]);
		}
		
	}

	public void surfaceLessThan501() {
		List<Object[]> table = this.countryRepo.lessThan501Surface();
		for(Object[] row : table) {
		    System.out.println("Country : " + row[0] +" population "+ row[1]+ " Surface area : "+ row[2]);
		}
		
	}
}
