package com.example.models;

public class Wizard extends Human {
	
	public Wizard(String name){
		super(name);
		this.setHealth(50);	
		this.setIntelligence(8);
	}
	public void heal(Human target){
		int healPoints = this.getIntelligence();
		target.setHealth(target.getHealth()+healPoints);
		System.out.println(this.getName() + " a sanado a : "+ target.getName());
	}
	public void fireBall(Human target){
		int damage = this.getIntelligence() * 3;
		target.setHealth(target.getHealth()- damage);
		System.out.println(this.getName() + " a lanzado una bola de fuego"
				+ " a : "+ target.getName());
	}
	
}
