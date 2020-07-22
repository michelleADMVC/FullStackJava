package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "languages")
public class Language {
	@Id
	@GeneratedValue
	private Long id;
	private String countryCode;
	private String language;
	private String isOfficial;
	private float percentage;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	Country country;
	public Language() {}
	public Country getCountry() {
		return country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public Long getId() {
		return id;
	}
	public String getIsOfficial() {
		return isOfficial;
	}
	public String getLanguage() {
		return language;
	}
	public float getPercentage() {
		return percentage;
	}
	@Override
	public String toString() {
		return "Language [language=" + language + "]";
	}
	 
	
}	
