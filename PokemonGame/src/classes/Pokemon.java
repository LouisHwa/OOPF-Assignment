package classes;

import java.util.Random;
import java.util.Scanner;

public abstract class Pokemon{
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

	public void setPokemonATK(double pokemonATK) {
		this.pokemonATK = (int) pokemonATK;
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
				"\nPokemon Z-Move: " + getPokemonZMove() + 
				"\n"; 
	}
	
	public String pokemonStats() {
		return String.format("%s HP: %s", getPokemonName(), getPokemonHP());
	}
	
	// Get attack name of that pokemon, return the attack damage. 
	public void Attack(Pokemon yourPokemon,Pokemon opponentPokemon) {
		// Pokemon attack display
		System.out.printf("%s uses %s on %s.\n",yourPokemon.getPokemonName(), yourPokemon.getPokemonATKName(), opponentPokemon.getPokemonName());
		
		// Display Attack 
		int attack = (int)((yourPokemon.checkEffectiveness(yourPokemon, opponentPokemon) * yourPokemon.getPokemonATK()) - opponentPokemon.getPokemonDEF());
		
		System.out.printf("Deals %s ATK on %s!\n",attack, opponentPokemon.getPokemonName());
		opponentPokemon.setPokemonHP(pokemonHP - attack);
	}
	
	public void ult(Pokemon yourPokemon, Pokemon opponentPokemon) {
		System.out.println("ULTIMATE !!!");
		System.out.printf("%s uses %s on %s.\n",yourPokemon.getPokemonName(), yourPokemon.getPokemonZMoveName(), opponentPokemon.getPokemonName());
		
		// Display Attack 
		int attack = (int)((yourPokemon.checkEffectiveness(yourPokemon, opponentPokemon) * yourPokemon.getPokemonZMove()) - opponentPokemon.getPokemonDEF());

		System.out.printf("Deals %s ATK on %s!\n",attack, opponentPokemon.getPokemonName());
		opponentPokemon.setPokemonHP(pokemonHP - attack);
	}
	
	// Increment the probability after each attack of that pokemon and this is to
	// randomly check the probability of hitting it. 
	public boolean checkZmove() {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int randnum = rand.nextInt(100) + 1; // Generates number between 1-100
		
		// Getting the zmove probability\
		int probability = (int)(this.getZmoveProbability() * 100); // All are 0.1, convert 0.1 to whole number %
		if(randnum >= 1 && randnum <= probability) {
			
			//Include this message in the battle class, here will be remove
			System.out.println("Z-Move Available!!");
			System.out.println("Press ENTER to use it!");
			input.nextLine();
			this.zmoveProbability = 0.1;
			return true;
		}else {
			this.zmoveProbability += 0.1;
			return false;
		}
	}
	
	
	// Check whether pokemon is allow to use zmove or not
	public abstract double checkEffectiveness(Pokemon yourPokemon, Pokemon opponentPokemon);
}
