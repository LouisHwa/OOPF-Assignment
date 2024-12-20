package classes;

public class Grass extends Pokemon{

	public Grass(String pokemonID, String pokemonName, String pokemonType, int pokemonHP, int pokemonRARITY,
			int pokemonATK, String pokemonATKName, int pokemonDEF, int pokemonZMove, String pokemonZMoveName,
			double zmoveProbability) {
		super(pokemonID, pokemonName, pokemonType, pokemonHP, pokemonRARITY, pokemonATK, pokemonATKName, pokemonDEF,
				pokemonZMove, pokemonZMoveName, zmoveProbability);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double checkEffectiveness(Pokemon yourPokemon, Pokemon opponentPokemon) {
		if(yourPokemon.getPokemonType().equals("Grass") && opponentPokemon.getPokemonType().equals("Ground")) {  // Effective against ground
			System.out.println("Attack Super Effective! x1.5 Multiplier");
			return 1.5;
		}else {
			System.out.println("Attack Neutral..");
			return 1;
		}
	}
}
