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
//		System.out.println(newPlayerList.get(0).getPlayerPokemons().get(0).pokemonInfo());
		System.out.println(newPlayerList.size());
//		for(Player player: newPlayerList) {
//			System.out.println(db.loadPlayerPokemons(player));
//		};
		System.out.println("------");
		System.out.println(newPlayerList.get(7));
		System.out.println("------");
		System.out.println();
	
		
		// Printing the top5
		int counter = 1;
		for(Player score: db.getTopFive()) {
			System.out.printf("%s. ID: %s, Score: %s\n", counter,score.getPlayerID(),score.getPlayerScore());
			counter++;
		};
		System.out.println();
		
		//Adding new player
		
		System.out.println(newPlayerList.get(7).getPlayerPokemons());
		System.out.println(newPlayerList.size());
		
		// Writing into text file
		System.out.println(newPlayerList.size());
		System.out.println(db.getPlayerList().get(7).getPlayerName() + db.getPlayerList().get(7).getPlayerPokemons());
		System.out.println(db.getPlayerList().get(8).getPlayerName()+ db.getPlayerList().get(8).getPlayerPokemons());

		// When new player added to the player list, it is stored as the value null.
		if(db.getPlayerList().get(8).getPlayerPokemons() == null) {
			System.out.println("Hey");
		}
		
		System.out.println(db.loadPlayerPokemons("P008"));
		if(db.loadPlayerPokemons("P008") == null) {
			System.out.println("EY");
			
		// When you explicitely get the playerpokemon it will return an empty string
		} else if(db.loadPlayerPokemons("P008").isEmpty()) {
			System.out.println("HUH");
		}
//		db.addPlayer("SiXuan");
//		db.writeToFile();
		
		
		
	}

}
