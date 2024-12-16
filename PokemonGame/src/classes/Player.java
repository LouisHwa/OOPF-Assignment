package classes;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private String playerID;
    private int playerScore;
    private int playerBattlePlayed;
    private List<Pokemon> playerPokemon;
    private int Medal;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerID = generatePlayerID();
        this.playerScore = 0;
        this.playerBattlePlayed = 0;
        this.playerPokemon = new ArrayList<>();
        this.Medal = 0;
    }

    public Player(String playerName, String playerID) {
        this.playerName = playerName;
        this.playerID = playerID;
        this.playerScore = 0;
        this.playerBattlePlayed = 0;
        this.playerPokemon = new ArrayList<Pokemon>();
        this.Medal = 0;
    }

    public Player(String playerName, String playerID, int playerScore, List<Pokemon> playerPokemon) {
        this.playerName = playerName;
        this.playerID = playerID;
        this.playerScore = playerScore;
        this.playerBattlePlayed = 0;
        this.playerPokemon = playerPokemon;
        this.Medal = 0;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
    
    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    
    public void setPlayerBattlePlayed(int playerBattlePlayed) {
        this.playerBattlePlayed = playerBattlePlayed;
    }
    
    public int getPlayerBattlePlayed() {
        return playerBattlePlayed;
    }

    public List<Pokemon> getPlayerPokemon() {
        return playerPokemon;
    }

    public void setPlayerPokemon(List<Pokemon> playerPokemon) {
        this.playerPokemon = playerPokemon;
    }

    public int getMedal() {
        return Medal;
    }

    public void setMedal(int medal) {
        this.Medal = medal;
    }

    public void displayMedal() {
        System.out.println("Medals: " + Medal);
    }

    public void displayBattlePlayed() {
        System.out.println("Battles Played: " + playerBattlePlayed);
    }

    private String generatePlayerID() {
        return "PLAYER" + (int) (Math.random() * 10000);
    }

}

