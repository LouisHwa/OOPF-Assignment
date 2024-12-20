package classes;

public class Water extends Pokemon{

	public Water(String pokemonID, String pokemonName, String pokemonType, int pokemonHP, int pokemonRARITY,
			int pokemonATK, String pokemonATKName, int pokemonDEF, int pokemonZMove, String pokemonZMoveName,
			double zmoveProbability) {
		super(pokemonID, pokemonName, pokemonType, pokemonHP, pokemonRARITY, pokemonATK, pokemonATKName, pokemonDEF,
				pokemonZMove, pokemonZMoveName, zmoveProbability);
		// TODO Auto-generated constructor stub
	}
	
	public double checkEffectiveness(Pokemon yourPokemon, Pokemon opponentPokemon) {
		if(yourPokemon.getPokemonType().equals("Water") && opponentPokemon.getPokemonType().equals("Fire")) {  // Effective against fire
			System.out.println("Attack Super Effective! x1.5 Multiplier");
			return 1.5;
		}else {
			System.out.println("Attack Neutral..");
			System.out.println("Water");
			return 1;
		}
	}
}
