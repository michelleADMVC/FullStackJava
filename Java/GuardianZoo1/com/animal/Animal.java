package com.animal;

public class Animal {
	
	private String name;
	private int energy;
	
	public Animal(String name) {
		this.name = name;
		this.energy= 100;
	}
	public String getName() {
		return this.name;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int displayEnergy() {
		System.out.println("Energia de "+ this.name +" : "+energy);
		return energy;
	}
}
