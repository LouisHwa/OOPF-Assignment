package classes;

public class Electric extends Pokemon{

	public Electric(String pokemonID, String pokemonName, String pokemonType, int pokemonHP, int pokemonRARITY,
			int pokemonATK, String pokemonATKName, int pokemonDEF, int pokemonZMove, String pokemonZMoveName,
			double zmoveProbability) {
		super(pokemonID, pokemonName, pokemonType, pokemonHP, pokemonRARITY, pokemonATK, pokemonATKName, pokemonDEF,
				pokemonZMove, pokemonZMoveName, zmoveProbability);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double checkEffectiveness(Pokemon yourPokemon, Pokemon opponentPokemon) {
		if(yourPokemon.getPokemonType().equals("Electric") && opponentPokemon.getPokemonType().equals("Water")) {  // Effective against grass
			System.out.println("Attack Super Effective!");
			return 1.5;
		}else {
			System.out.println("Attack Neutral..");
			System.out.println("Electric");
			return 1;
		}
	}
}
