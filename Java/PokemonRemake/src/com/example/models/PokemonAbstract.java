package com.example.models;

import java.util.ArrayList;

public abstract class PokemonAbstract implements PokemonInterface {
	ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();
	
	public ArrayList<Pokemon> getMyPokemons() {
		return myPokemons;
	}
	
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon newPokemon = new Pokemon(name,type,health);
		myPokemons.add(newPokemon);
		return newPokemon;
	}
	
	@Override
	public String pokemonInfo(Pokemon pokemon) {
		String info = "Pokemon : "+pokemon.getName()
		+" | Salud : "+pokemon.getHealth()
		+" | Tipo : "+pokemon.getType();
		return info;
	}
}
