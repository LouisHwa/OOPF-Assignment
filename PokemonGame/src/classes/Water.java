package classes;

public class Water extends Pokemon{

	public Water(String pokemonID, String pokemonName, String pokemonType, int pokemonHP, int pokemonRARITY,
			int pokemonATK, String pokemonATKName, int pokemonDEF, int pokemonZMove, String pokemonZMoveName,
			double zmoveProbability) {
		super(pokemonID, pokemonName, pokemonType, pokemonHP, pokemonRARITY, pokemonATK, pokemonATKName, pokemonDEF,
				pokemonZMove, pokemonZMoveName, zmoveProbability);
		// TODO Auto-generated constructor stub
	}
	
	public double checkEffectiveness(String opponentType) {
		if(opponentType.equals("Electric")) {  // Effective
			return 1.5;
		}else {
			return 0;
		}
	}
}
