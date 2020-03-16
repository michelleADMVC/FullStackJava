package com.human;

public class Human {
	private int strength, intelligence, stealth, health;
	private String className, playerName;
	
	public Human(String playerName) {
		this.playerName = playerName;
		this.health = 100;
	}
	
	public void attack(Human target) {
		System.out.println(this.playerName+" a atacado a "+target.playerName+"!");
		target.setHealth(target.getHealth() - this.strength);
		if (target.getHealth() < 0) {
			System.out.println(this.getPlayerName() + " a asesinado a :"+target.getPlayerName());
		}
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return health;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public int getIntelligence() {
		return intelligence;
	}
	public String getPlayerName() {
		return playerName;
	}
	public int getStrength() {
		return strength;
	}
	public int getStealth() {
		return stealth;
	}
	public void setAtributes(int strength, int intelligence, int stealth) {
		this.intelligence = intelligence;
		this.strength = strength;
		this.stealth = stealth;
	}
	public void displayHealth() {
		System.out.println("Salud de : "+this.getPlayerName());
		System.out.println(this.getHealth());
		
		if (this.getHealth() < 0) {
			System.out.println(this.getPlayerName() + " esta muerto!");
		}
		System.out.println("--------------------------------------------");
	}
	public void display() {
		System.out.println("Nombre del jugador : "+this.getPlayerName());
		System.out.println("Clase : "+ this.getClassName());
		System.out.println("Salud : "+this.getHealth());
		System.out.println("Stats : "+ getStats());
		System.out.println("--------------------------------------------");
		
	}
	private String getStats() {
		String inte = "Inteligencia : " +this.getIntelligence();
		String strng  = "Fuerza : " +this.getStrength();
		String steal = "Resistencia : " + this.getStealth(); 
		return inte +"| "+ strng +"| " + steal;
	}
}
