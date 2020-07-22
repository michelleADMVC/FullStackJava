package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String country_code;
	private String district;
	private int population;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	Country country;
	public City() {}
	public String getCountry_code() {
		return country_code;
	}
	public String getDistrict() {
		return district;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country_code=" + country_code + ", district=" + district
				+ ", population=" + population + "]";
	}
	
	
}
