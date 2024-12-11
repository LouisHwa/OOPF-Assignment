package classes;

import java.util.ArrayList;

public class testPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.readPokemonFile();
		db.readPlayerFile();
		
		ArrayList<Player> pList = db.getPlayerList();
		Player player1 = pList.get(0);
		Player player2 = pList.get(2);
		
		player1.displayPlayerPokemon();
		System.out.println();
		player2.displayPlayerPokemon();
		
		//Dynamically creating a new pokemon variable so it wouldn't affect the main one.
		Pokemon pp1 = player1.getPlayerPokemons().get(1);
		Pokemon pp2 = player2.getPlayerPokemons().get(1);
		System.out.println(pp1.pokemonInfo());
		System.out.println();
		System.out.println(pp2.pokemonInfo());
		System.out.println();
		
		
		//Display the Dynamic when two pokemons attack
		System.out.println("Attacking Dynamic..");
		System.out.println("Stats before attack");
		System.out.println("Pikachu HP: " + pp2.getPokemonHP()); 
		System.out.println("Pikachu ATK: " + pp2.getPokemonATK());  
		System.out.println("Articuno HP: " + pp1.getPokemonHP()); 
		System.out.println("Articuno ATK: " + pp1.getPokemonATK()); 
		System.out.println("===========================");
		pp1.Attack(pp2, pp1);
		System.out.println("===========================");
		System.out.println("Stats After 1 attack");
		System.out.println("Pikachu HP: " + pp2.getPokemonHP()); 
		System.out.println("Pikachu ATK: " + pp2.getPokemonATK());  
		System.out.println("Articuno HP: " + pp1.getPokemonHP()); 
		System.out.println("Articuno ATK: " + pp1.getPokemonATK()); 
		System.out.println();
		
		// Test Z move
		System.out.println("Z-move testing");
		int counter = 1;
		for(int i=0; i < 6; i++) {
			System.out.printf("%s. encounter.\n", counter);
			if(pp1.checkZmove()) {
				break;
			};
			System.out.println();
			counter++;
		}
		
		
	}

}
