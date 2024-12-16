package classes;

import java.util.ArrayList;
import java.util.Random;

public class pokeball_test {

	public static void main(String[] args) {
		
		PokemonBall[] balls = {new Masterball(), new Ultraball(),new Greatball(), new Pokeball()};
		PokemonBall playerball = PokemonBall.ballGenerator(balls);
		
		System.out.println("You got a " + playerball.getBallName() + "!");
		
		Database db = new Database();
		db.readPokemonFile();
		db.readPlayerFile();
		
		ArrayList<Player> plist = db.getPlayerList();
		Player p1 = plist.get(1);
		p1.displayPlayerPokemon();

	
		
		
		ArrayList<Pokemon> pokelist = db.getPokemonList();
		Pokemon pp1 = pokelist.get(5);
//		System.out.println(pp1.getPokemonName());
		
		
		
		
//		boolean SR = playerball.checkSuccess(pp1, playerball);
//		
//		if(SR) {
//			ArrayList<Pokemon> e1 = p1.getPlayerPokemons();
//			e1.add(pp1);
//			p1.setPlayerPokemons(e1);
//			System.out.println("You succesfully captured " + pp1.getPokemonName() + " with your " + playerball.getBallName());
//			System.out.println( pp1.getPokemonName() + " has been added to your inventory \n");
//			p1.displayPlayerPokemon();
//			db.writeToFile();
//			
//		}else {
//			System.out.println("You failed to capture " + pp1.getPokemonName());
//		}
		
		PokemonBall pb = new PokemonBall();
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println(playerball);
			boolean success = pb.checkSuccess(pp1, playerball);
			if(success) {
				System.out.println("SUCCESS");
			}else {
				System.out.println("FAIL");
			}
		}
		
		
	}

}
