
public class Launcher {

	public static void main(String[] args) {
		Pokedex test = new Pokedex();
		test.createPokemon("Venosaurox", 100, "Pasto");
		test.createPokemon("Picashuxs", 100, "Corrientecs");
		test.listPokemon();
		test.selectPokemon(0).attack(test.selectPokemon(1));
		test.listPokemon();
	}

}
