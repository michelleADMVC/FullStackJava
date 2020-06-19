package com.example.test;
import com.example.models.*;
public class Pokedex extends PokemonAbstract {
	
	public Pokemon getPokemon(int index) {
		return this.getMyPokemons().get(index);
	}
	
	@Override
	public void listPokemon() {
		for (int i = 0; i < this.getMyPokemons().size(); i++) {
			System.out.println(pokemonInfo(this.getMyPokemons().get(i)));
		}
		
	}

}
