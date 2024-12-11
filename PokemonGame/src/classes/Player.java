package classes;

import java.util.ArrayList;

public class Player {
	private String playerID;
	private String playerName;
	private int playerScore;
	private int playerBattlePlayed;
	private ArrayList<Pokemon> playerPokemons;
	private int playerMedal;
	
	
	public Player() {
		
	}
	
	
	public Player(String playerID, String playerName) {
		this(playerID, playerName, 0, 0, null, 0);
	}

	public Player(String playerID, String playerName, int playerScore, int playerBattlePlayed,
			ArrayList<Pokemon> playerPokemons, int playerMedal) {
		this.playerID = playerID;
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.playerBattlePlayed = playerBattlePlayed;
		this.playerPokemons = playerPokemons;
		this.playerMedal = playerMedal;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}


	public int getPlayerScore() {
		return playerScore;
	}


	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}


	public int getPlayerBattlePlayed() {
		return playerBattlePlayed;
	}


	public void setPlayerBattlePlayed(int playerBattlePlayed) {
		this.playerBattlePlayed = playerBattlePlayed;
	}


	public ArrayList<Pokemon> getPlayerPokemons() {
		return playerPokemons;
	}


	public void setPlayerPokemons(ArrayList<Pokemon> playerPokemons) {
		this.playerPokemons = playerPokemons;
	}


	public int getPlayerMedal() {
		return playerMedal;
	}


	public void setPlayerMedal(int playerMedal) {
		this.playerMedal = playerMedal;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Player [playerID=%s, playerName=%s, playerScore=%s, playerBattlePlayed=%s, playerPokemons=%s, playerMedal=%s]",
				playerID, playerName, playerScore, playerBattlePlayed, playerPokemons, playerMedal);
	}
	
	public void displayPlayerPokemon() {
		int counter = 1;
		System.out.println("Your Pokemons: ");
		for(Pokemon pokemon: playerPokemons) {
			System.out.printf("%s. %s\n", counter, pokemon.getPokemonName());
			counter++;
		}
	}


	
	
	
}
