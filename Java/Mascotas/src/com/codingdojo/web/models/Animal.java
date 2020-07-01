package com.codingdojo.web.models;

public class Animal {
	private String name;
	private String breed;
	private int weight;
	
	public Animal(String name, String breed, int weigth){
		this.name = name;
		this.breed = breed; 
		this.weight = weigth;
	}
	public String getBreed() {
		return this.breed;
	}
	public String getName() {
		return this.name;
	}
	public int getWeight() {
		return this.weight;
	}
}
