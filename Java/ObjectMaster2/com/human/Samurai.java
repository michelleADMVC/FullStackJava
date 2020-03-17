package com.human;

public class Samurai extends Human{

	public Samurai(String playerName) {
		super(playerName);
		this.setClassName("Samurai");
		int health = 200;
		int strength = 20 ;
		int intelligence = 2;
		int stealth = 8;
		this.setAtributes(health ,strength, intelligence, stealth);
		System.out.println("Se ha creado un jugador de clase "+this.getClassName());
	}
	
	public void deathBlow(Human target) {
		target.setHealth(0);
		System.out.println(target.getPlayerName()+ " a recibido un golpe mortal de "+ this.getPlayerName());
		this.setHealth(getHealth()/2);
	}

	public void meditate() {
		System.out.println(this.getPlayerName()+ " a meditado");
		int heal = this.getHealth()/2;
		this.setHealth(this.getHealth() + heal);
	}
	public void howMany() {
		display();
	}
}
