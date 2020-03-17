package com.human;

public class Wizard extends Human{
	
	public Wizard(String playerName) {
		super(playerName);
		this.setClassName("Wizard");
		int health = 50;
		int strength = 4;
		int intelligence = 8;
		int stealth = 20;
		this.setAtributes(health ,strength, intelligence, stealth);
		System.out.println("Se ha creado un jugador de clase "+this.getClassName());
	}
	public void heal(Human target) {
		System.out.println(this.getPlayerName()+" a curado a "+target.getPlayerName()+"!");
		target.setHealth(target.getHealth() + this.getIntelligence());
		
	}
	public void fireball(Human target) {
		System.out.println(this.getPlayerName()+" a achicharrado a "+target.getPlayerName()+"!");
		int damage = this.getIntelligence()* 3;
		target.setHealth(target.getHealth() - damage);
	}

}
