package classes;

import java.io.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class testDatabase {

	public static void main(String[] args) {
		Database db = new Database();
		db.readPokemonFile();
		db.readPlayerFile();
		ArrayList<Player> pList= db.getPlayerList();	
		Player player1 = pList.get(0); // Contains pokemon1
		System.out.println(player1.getPlayerPokemons());
		
		ArrayList<Pokemon> pkmList = db.getPokemonList();
		Pokemon pokemon1 = pkmList.get(0);
		System.out.println(pokemon1);
		for(Pokemon p : player1.getPlayerPokemons()) {
			if(!(p.equals(pokemon1))) {
				System.out.println("It works heh");
				break;
			}else {
				System.out.println("It doesnt");
				break;
			}
		}
		
//		
//		if(!player1.getPlayerPokemons().contains(pokemon1)) {
//			System.out.println("It works");
//		}else {
//			System.out.println("It doesnt");
//		}
		
	}

}
