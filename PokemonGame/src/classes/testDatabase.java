package classes;

import java.io.File;
import java.util.ArrayList;

public class testDatabase {

	public static void main(String[] args) {
		Database db = new Database();
		db.readPokemonFile();
		
		
		System.out.println(db.getPokemonList());
		ArrayList<Pokemon> newList = new ArrayList<Pokemon>();
		newList = db.getPokemonList();
		
		System.out.println(newList.get(1).pokemonInfo());
		
		db.getPlayerPokemons("P001");
	}

}
