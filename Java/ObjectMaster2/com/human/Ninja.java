package com.human;

public class Ninja extends Human{

	public Ninja(String playerName) {
		
		super(playerName);
		this.setClassName("Ninja");
		int health = 100;
		int strength = 10;
		int intelligence = 4;
		int stealth = 10 ;
		this.setAtributes(health ,strength, intelligence, stealth);
		System.out.println("Se ha creado un jugador de clase "+this.getClassName());
	}
	public void steal(Human target) {
		System.out.println(this.getPlayerName()+" a robado a "+target.getPlayerName()+"!");
		target.setHealth(target.getHealth() - this.getStealth());		
		if (target.getHealth() < 0) {
			System.out.println(this.getPlayerName() + " a asesinado a :"+target.getPlayerName());
		}
		this.setHealth(this.getHealth() + this.getStealth());
	}
	
	public void runAway() {
		System.out.println(this.getPlayerName()+" a huido!");
		this.setHealth(this.getHealth()-10);
	}
	
	

}
