package com.example.test;

import com.example.models.Pokemon;

public class Test {

	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		testInstances(pokedex);
		pokedex.listPokemon();
		System.out.println("Pokemon instanciados : "+Pokemon.count);
		pokedex.getPokemon(0).atackPokemon(pokedex.getPokemon(2));
		pokedex.listPokemon();
	}
	
	public static void testInstances(Pokedex pokedex){
		pokedex.createPokemon("Ardilla", 13, "Pokemon...creo");
		pokedex.createPokemon("Pikachu", 20, "Raio");
		pokedex.createPokemon("Ivysaur", 20, "Lechuga");
	}

}
