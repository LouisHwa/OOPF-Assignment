package classes;

import java.util.Random;

public class pokeball_test {

	public static void main(String[] args) {
		PokemonBall[] balls = { new Pokeball(), new Greatball(), new Ultraball(), new Masterball() };
		
		PokemonBall random = PokemonBall.ballGenerator(balls);
		
		System.out.println(random);
		
		
		Double rnd = new Random().nextDouble();
		System.out.println(rnd);
	}

}
