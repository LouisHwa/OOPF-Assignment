package classes;


public class Pokemon {
	private String pokemonID;
	private String pokemonName;
	private String pokemonType;
	private int pokemonHP;
	private int pokemonRARITY;
	private int pokemonATK;
	private String pokemonATKName;
	private int pokemonDEF;
	private int pokemonZMove;
	private String pokemonZMoveName;
	private double zmoveProbability;
	
	public Pokemon(String pokemonID, String pokemonName, String pokemonType, int pokemonHP, int pokemonRARITY,
			int pokemonATK, String pokemonATKName, int pokemonDEF, int pokemonZMove, String pokemonZMoveName,
			double zmoveProbability) {
		super();
		this.pokemonID = pokemonID;
		this.pokemonName = pokemonName;
		this.pokemonType = pokemonType;
		this.pokemonHP = pokemonHP;
		this.pokemonRARITY = pokemonRARITY;
		this.pokemonATK = pokemonATK;
		this.pokemonATKName = pokemonATKName;
		this.pokemonDEF = pokemonDEF;
		this.pokemonZMove = pokemonZMove;
		this.pokemonZMoveName = pokemonZMoveName;
		this.zmoveProbability = zmoveProbability;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public String getPokemonType() {
		return pokemonType;
	}

	public void setPokemonType(String pokemonType) {
		this.pokemonType = pokemonType;
	}

	public int getPokemonHP() {
		return pokemonHP;
	}

	public void setPokemonHP(int pokemonHP) {
		this.pokemonHP = pokemonHP;
	}

	public int getPokemonRARITY() {
		return pokemonRARITY;
	}

	public void setPokemonRARITY(int pokemonRARITY) {
		this.pokemonRARITY = pokemonRARITY;
	}

	public int getPokemonATK() {
		return pokemonATK;
	}

	public void setPokemonATK(int pokemonATK) {
		this.pokemonATK = pokemonATK;
	}

	public String getPokemonATKName() {
		return pokemonATKName;
	}

	public void setPokemonATKName(String pokemonATKName) {
		this.pokemonATKName = pokemonATKName;
	}

	public int getPokemonDEF() {
		return pokemonDEF;
	}

	public void setPokemonDEF(int pokemonDEF) {
		this.pokemonDEF = pokemonDEF;
	}

	public int getPokemonZMove() {
		return pokemonZMove;
	}

	public void setPokemonZMove(int pokemonZMove) {
		this.pokemonZMove = pokemonZMove;
	}

	public String getPokemonZMoveName() {
		return pokemonZMoveName;
	}

	public void setPokemonZMoveName(String pokemonZMoveName) {
		this.pokemonZMoveName = pokemonZMoveName;
	}

	public double getZmoveProbability() {
		return zmoveProbability;
	}

	public void setZmoveProbability(double zmoveProbability) {
		this.zmoveProbability = zmoveProbability;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Pokemon [pokemonID=%s, pokemonName=%s, pokemonType=%s, pokemonHP=%s, pokemonRARITY=%s, pokemonATK=%s, pokemonATKName=%s, pokemonDEF=%s, pokemonZMove=%s, pokemonZMoveName=%s, zmoveProbability=%s]",
				pokemonID, pokemonName, pokemonType, pokemonHP, pokemonRARITY, pokemonATK, pokemonATKName, pokemonDEF,
				pokemonZMove, pokemonZMoveName, zmoveProbability);
	}

	public String pokemonInfo() {
		return "Pokemon Name: "  + getPokemonName() + 
				"\nPokemon Type: " + getPokemonType() + 
				"\nPokemon Rarity: " + getPokemonRARITY() + 
				"\nPokemon HP: " + getPokemonHP() + 
				"\nPokemon ATK: " + getPokemonATK() + 
				"\nPokemon DEF: " + getPokemonDEF() + 
				"\nPokemon Z-Move: " + getPokemonZMove();
			
	}
}
