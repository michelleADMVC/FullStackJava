package com.codingdojo.web.models;

public class Dog extends Animal implements Pet  {

	public Dog(String name, String breed, int weigth) {
		super(name, breed, weigth);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showAffection() {
		String line;
		if(this.getWeight() < 30 ){
			line = "you created, "+this.getName()+",this dog have less than 30lbs";
		}else {
			line = "you created, "+this.getName()+" ,this dog have more than 30lbs";
		}
		return line;
	}

}
