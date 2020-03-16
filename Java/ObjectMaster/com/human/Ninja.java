package com.human;

public class Ninja extends Human{

	public Ninja(String playerName) {
		
		super(playerName);
		this.setClassName("Ninja");
		this.setAtributes(20, 10, 20);
		System.out.println("Se ha creado un jugador de clase "+this.getClassName());
	}
	

}
