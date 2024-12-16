package classes;

import java.util.ArrayList;

public class pokeball_test {

	public static void main(String[] args) {
		
		PokemonBall[] balls = {new Masterball(), new Ultraball(),new Greatball(), new Pokeball()};
		PokemonBall playerball = PokemonBall.ballGenerator(balls);

		System.out.println("You got a " + playerball.getBallName() + "!");
		
		Database db = new Database();
		db.readPlayerFile();
		db.readPokemonFile();
		
//		ArrayList<Player> plist = db.getPlayerList();
//		Player p1 = plist.get(0);
//		p1.displayPlayerPokemon();
		
		ArrayList<Pokemon> pokelist = db.getPokemonList();
		Pokemon pp1 = pokelist.get(0);
		System.out.println(pp1.getPokemonName());
		
		
		
		
		boolean SR = playerball.checkSuccess(pp1, playerball);
		
		if(SR) {
			System.out.println("You succesfully captured " + pp1.getPokemonName());
			
		}else {
			System.out.println("You failed to capture " + pp1.getPokemonName());
		}
		
		
	}

}
