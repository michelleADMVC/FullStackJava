package com.human;

public class Wizard extends Human{
	
	public Wizard(String playerName) {
		super(playerName);
		this.setClassName("Wizard");
		this.setAtributes(10, 20, 10);
		System.out.println("Se ha creado un jugador de clase "+this.getClassName());
	}

}
