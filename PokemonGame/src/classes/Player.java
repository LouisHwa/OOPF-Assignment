package classes;

import java.util.ArrayList;

public class Player {
	private String playerName;
	private String playerID;
	private int playerScore;
	private int playerBattlePlayed;
	private ArrayList<Pokemon> playerPokemons;
	private int playerMedal;
	
	
	public Player(String playerName, String playerID, int playerScore, int playerBattlePlayed,
			ArrayList<Pokemon> playerPokemons, int playerMedal) {
		super();
		this.playerName = playerName;
		this.playerID = playerID;
		this.playerScore = playerScore;
		this.playerBattlePlayed = playerBattlePlayed;
		this.playerPokemons = playerPokemons;
		this.playerMedal = playerMedal;
	}
	
	
	
}
