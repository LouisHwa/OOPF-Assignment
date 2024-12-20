package classes;

import java.util.ArrayList;

public class Player {
	private String playerID;
	private String playerName;
	private int playerScore;
	private int playerBattlePlayed;
	private ArrayList<Pokemon> playerPokemons;
	private int playerMedal;
	
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
				"toString Player [playerID=%s, playerName=%s, playerScore=%s, playerBattlePlayed=%s, playerPokemons=%s, playerMedal=%s]",
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


	public void displayMedal() {
        System.out.println("Medals: " + playerMedal);
    }

    public void displayBattlePlayed() {
        System.out.println("Battles Played: " + playerBattlePlayed);
    }
    
    public void displayPlayerInformation() {
        System.out.printf(
            "=============== Player Information ===============\n" +
            " Player ID      : %s\n" +
            " Player Name    : %s\n" +
            " Player Score   : %d\n" +
            " Battle Played  : %d\n" +
            " Player Medal   : %s\n" +
            " Player Pokemons: ",
            this.playerID,
            this.playerName,
            this.playerScore,
            this.playerBattlePlayed,
            this.playerMedal
        );
        for (int i = 0; i < this.playerPokemons.size(); i++) {
            System.out.print(this.playerPokemons.get(i).getPokemonName());
            
            // Only add a comma if it's not the last element
            if (i < this.playerPokemons.size() - 1) {
                System.out.print(", ");
            }
            
            if ((i + 1) % 3 == 0 && i < this.playerPokemons.size() - 1) {
                System.out.println();  // Print newline after every 3rd pokemon
            }
        
        }
        
        System.out.println("\n==================================================\n");
    }

	
	
}

