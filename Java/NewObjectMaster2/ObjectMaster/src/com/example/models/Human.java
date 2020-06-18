package com.example.models;

public class Human {
	
	private String name;
	private int strength;
	private int intelligence;
	private int stealth;
	private int health;
	
	public Human(String name ) {
		this.name = name;
		 defaultAtributes();
	}
	
	private void defaultAtributes(){
		this.strength = 3;
		this.intelligence = 3;
		this.stealth = 3;
		this.health = 100;
	}
	
	public void attack(Human target){
		int damage = this.getStrength();
		target.setHealth((target.getHealth() - damage));
		System.out.println(this.getName() + " a atacado a : "+ target.getName());
	}
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public int getStrength() {
		return strength;
	}
	public int getStealth() {
		return stealth;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public void displayInfo(){
		System.out.println(
				"Name : "+this.getName()+
				"\n Health: "+this.getHealth()+
				"\n Intelligence: "+this.getIntelligence()+
				"\n Stealth: "+this.getStealth()+
				"\n Strength :"+this.getStrength());
	}
}
