package com.human;

public class Samurai extends Human{

	public Samurai(String playerName) {
		super(playerName);
		this.setClassName("Samurai");
		this.setAtributes(40, 8, 15);
		System.out.println("Se ha creado un jugador de clase "+this.getClassName());
	}


	
}
