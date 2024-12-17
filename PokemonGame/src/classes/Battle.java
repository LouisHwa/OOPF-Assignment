package classes;
import java.util.ArrayList;

public class Battle {
   
    private Player player;
    private Pokemon playerPokemon;
    private Pokemon wildPokemon;
    private String state; 
    private double multiplier;

   
    public Battle(Player player, Pokemon playerPokemon, Pokemon wildPokemon, double multiplier) {
        this.player = player;
        this.playerPokemon = playerPokemon;
        this.wildPokemon = wildPokemon;
        this.state = "inProgress";
        this.multiplier = multiplier;
    }

   
    public void startBattle() {
        System.out.println("Battle started between " + playerPokemon.getPokemonName() + " and " + wildPokemon.getPokemonName());
    }

 
    public void endBattle() {
        this.state = "finished";
        System.out.println("Battle ended.");
    }

   
    public void playerAttack() {
        double effectiveness = playerPokemon.checkEffectiveness(wildPokemon.getPokemonType());
        int damage = (int) (playerPokemon.getPokemonATK() * effectiveness * multiplier);
        int remainingHP = wildPokemon.getPokemonHP() - damage;
        wildPokemon.setPokemonHP(Math.max(remainingHP, 0));
        System.out.println(playerPokemon.getPokemonName() + " attacked " + wildPokemon.getPokemonName() + " for " + damage + " damage.");
    }

    
    public void wildAttack() {
        double effectiveness = wildPokemon.checkEffectiveness(playerPokemon.getPokemonType());
        int damage = (int) (wildPokemon.getPokemonATK() * effectiveness);
        int remainingHP = playerPokemon.getPokemonHP() - damage;
        playerPokemon.setPokemonHP(Math.max(remainingHP, 0));
        System.out.println(wildPokemon.getPokemonName() + " attacked " + playerPokemon.getPokemonName() + " for " + damage + " damage.");
    }

  
    public void processTurn() {
        if (state.equals("finished")) {
            System.out.println("The battle is already finished.");
            return;
        }

        playerAttack();
        if (wildPokemon.getPokemonHP() <= 0) {
            System.out.println(wildPokemon.getPokemonName() + " fainted!");
            endBattle();
            return;
        }

        wildAttack();
        if (playerPokemon.getPokemonHP() <= 0) {
            System.out.println(playerPokemon.getPokemonName() + " fainted!");
            endBattle();
        }
    }

   
    public Player displayWinner() {
        if (state.equals("inProgress")) {
            System.out.println("The battle is still in progress.");
            return null;
        }

        if (playerPokemon.getPokemonHP() > 0) {
            System.out.println(player.getPlayerName() + " wins the battle!");
            return player;
        } else {
            System.out.println("The wild Pokémon wins the battle!");
            return null;
        }
    }

    
    public ArrayList<Pokemon> getWildPokemon() {
        ArrayList<Pokemon> wildPokemons = new ArrayList<>();
        wildPokemons.add(wildPokemon);
        return wildPokemons;
    }

   
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
