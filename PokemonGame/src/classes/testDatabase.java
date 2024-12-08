package classes;

import java.io.File;
import java.util.ArrayList;

public class testDatabase {

	public static void main(String[] args) {
		Database db = new Database();
		db.readPokemonFile();
		db.readPlayerFile();
//		System.out.println(db.getPokemonList().size());
		
//		
		ArrayList<Pokemon> newList = new ArrayList<Pokemon>();
		newList = db.getPokemonList();
		System.out.println(newList.size());
		System.out.println(newList);
		System.out.println();
		
//		System.out.println(newList.get(1).pokemonInfo());
//		System.out.println(db.getPlayerList());
		
		// Printing Player's Pokemon
		ArrayList<Player> newPlayerList = new ArrayList<Player>();
		newPlayerList = db.getPlayerList();
		System.out.println(newPlayerList);
		System.out.println(newPlayerList.get(0).getPlayerPokemons().get(0).pokemonInfo());
		System.out.println(newPlayerList.size());
		for(Player player: newPlayerList) {
			System.out.println(player.getPlayerName());
		};
		System.out.println();
	
		
		// Printing the top5
		int counter = 1;
		for(Player score: db.getTopFive()) {
			System.out.printf("%s. ID: %s, Score: %s\n", counter,score.getPlayerID(),score.getPlayerScore());
			counter++;
		};
		System.out.println();
		
		//Adding new player
		db.addPlayer("Jeremy");
		System.out.println(newPlayerList.get(7).getPlayerPokemons());
		System.out.println(newPlayerList.size());
		
	}

}
