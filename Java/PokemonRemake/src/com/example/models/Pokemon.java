package com.example.models;

public class Pokemon {
	public static int count;
	private String name;
	private String type;
	private int health;
	
	public Pokemon(String name,String type, int health){
		this.name = name;
		this.type = type;
		this.health = health;
		count++;
	}
	public void atackPokemon (Pokemon pokemon){
		pokemon.setHealth(pokemon.getHealth() - 10);
		System.out.println("El pokemon : "+this.getName()+
				" a atacado a : "+ pokemon.getName());
	}
	public int getHealth() {
		return health;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
}

