

public class Pokedex extends PokemonAbstract{
	public int myPokemons;

	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		this.myPokemons++;
		return super.createPokemon(name, health, type);
	}
	@Override
	public void listPokemon() {
		for (int i = 0; i < arrayPokemons.size(); i++) {
			pokemonInfo(this.arrayPokemons.get(i));
		}
	}
	@Override
	public Pokemon selectPokemon(int index) {
		return arrayPokemons.get(index);
	}

}
