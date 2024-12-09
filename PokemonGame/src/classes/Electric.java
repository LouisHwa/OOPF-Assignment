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
	public double checkEffectiveness(String opponentType) {
		if(opponentType.equals("Ground")) {  // Effective
			return 1.5;
		}else {
			return 0;
		}
	}
}
