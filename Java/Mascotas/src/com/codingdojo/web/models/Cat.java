package com.codingdojo.web.models;

public class Cat extends Animal implements Pet  {

	public Cat(String name, String breed, int weigth) {
		super(name, breed, weigth);
		
	}

	@Override
	public String showAffection() {
		return "Your "+this.getBreed()+ " cat, "+getName()+ " looked"
				+ " your for some affection. You think";
	}
	

}
