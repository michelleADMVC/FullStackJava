import java.util.ArrayList;

public abstract class PokemonAbstract 	implements PokemonInterface {
	ArrayList<Pokemon> arrayPokemons = new ArrayList<Pokemon>();
@Override
public Pokemon createPokemon(String name, int health, String type) {
	Pokemon newPokemon = new Pokemon(name,health,type);
	arrayPokemons.add(newPokemon);
	return newPokemon;
}
@Override
	public String pokemonInfo(Pokemon pokemon) {
		System.out.println("Nombre del pokemon : "+pokemon.getName());
		System.out.println("Salud del pokemon : "+pokemon.getHealth());
		System.out.println("Tipo de pokemon : "+pokemon.getType());
		return null;
	}

}

