package classes;

import java.util.Random;

public class pokeball_test {

	public static void main(String[] args) {
		
		PokemonBall[] balls = {new Masterball(), new Ultraball(),new Greatball(), new Pokeball()};
		PokemonBall playerball = PokemonBall.ballGenerator(balls);
		System.out.println(playerball);
		
		
		
		
		
	}

}
