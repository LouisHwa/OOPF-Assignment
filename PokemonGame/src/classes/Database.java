package classes;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Database {
	private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private static File pokemonFile = new File("pokemonDetails.txt");
	private static File playerFile = new File("playerDetails.txt");
	
	public ArrayList<Pokemon> getPokemonList(){
		return this.pokemonList;
	}
	
	public ArrayList<Player> getPlayerList(){
		return this.playerList;
	}
	
	
	public static Class<? extends Pokemon> getPokemonTypeMap(String type) {
        Map<String, Class<? extends Pokemon>> pokemonTypeMap = new HashMap<>();
        pokemonTypeMap.put("Electric", Electric.class);
        pokemonTypeMap.put("Water", Water.class);
        pokemonTypeMap.put("Ground", Ground.class);
        pokemonTypeMap.put("Grass", Grass.class);
        pokemonTypeMap.put("Fire", Fire.class);
        return pokemonTypeMap.get(type);
    }
	
	
	// Reads all the details in pokemon file and stored in pokemonList
	public void readPokemonFile() {
		try {
			Scanner reader = new Scanner(Database.pokemonFile);
			
			while(reader.hasNextLine()) {
				String lines = reader.nextLine();
				String[] pokemonDetails = lines.split(",");
				
				String pokemonType = pokemonDetails[2];
				Class<? extends Pokemon> pokemonClass = getPokemonTypeMap(pokemonType);
				
				try {
					Constructor<? extends Pokemon> constructorType = pokemonClass.getConstructor(
							String.class, String.class, String.class, int.class, int.class, int.class, String.class, int.class, int.class, String.class, double.class);
				
					Pokemon pokemon = constructorType.newInstance(pokemonDetails[0], pokemonDetails[1], pokemonDetails[2], 
							Integer.parseInt(pokemonDetails[3]), Integer.parseInt(pokemonDetails[4]), Integer.parseInt(pokemonDetails[5]),
							pokemonDetails[6], Integer.parseInt(pokemonDetails[7]), Integer.parseInt(pokemonDetails[8]), 
							pokemonDetails[9], Double.parseDouble(pokemonDetails[10]));
					
					this.pokemonList.add(pokemon);	
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			};
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Reads all the details in player file and stored in playerList
	public void readPlayerFile() {
		try {
			Scanner reader = new Scanner(Database.playerFile);
			while(reader.hasNextLine()) {
				String lines = reader.nextLine();
				String[] playerDetails = lines.split(",");
				
				Player player = new Player(playerDetails[0], playerDetails[1], Integer.parseInt(playerDetails[2]), 
						Integer.parseInt(playerDetails[3]), loadPlayerPokemons(playerDetails[0]), Integer.parseInt(playerDetails[5]));

				this.playerList.add(player);
			};
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Getting top Five players
	public ArrayList<Player> getTopFive(){
		ArrayList<Player> temp = new ArrayList<Player>();
		
		for(int i = 0; i < this.playerList.size(); i++) {
			temp.add(this.playerList.get(i));
		}
		
		temp.sort((p1, p2) -> p2.getPlayerScore() - p1.getPlayerScore());
		ArrayList<Player> topFive = new ArrayList<>(temp.subList(0, Math.min(5, temp.size())));
		return topFive;
		
	}
	
	// Getting the players pokemon in the txt and stored it accordingly in the playerList
	public ArrayList<Pokemon> loadPlayerPokemons(String playerID){
		ArrayList<Pokemon> playerOwnedPokemons = new ArrayList<Pokemon>();
		try {
			Scanner reader = new Scanner(Database.playerFile);
			while(reader.hasNextLine()){
				String lines = reader.nextLine();
				String[] playerDetails = lines.split(",");
				if(playerDetails[0].equals(playerID)) {
					
					
					// Check if the pokemon return the value "null"
					if(!playerDetails[4].equals("null")){
						String[] tempList = playerDetails[4].split("-");
						for(String pokemon: tempList) {
							int index = -1;
							for(int i = 0; i < pokemonList.size(); i++) {
								if (pokemonList.get(i).getPokemonName().equals(pokemon)) {
									index = i;
									break;
								}
							}
							if(index != -1) {
								playerOwnedPokemons.add(pokemonList.get(index));
							}
						}
					}else {
						playerOwnedPokemons = null;
					}
				}
			}
			reader.close();
			return playerOwnedPokemons;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Adding new players to the playerList
	public void addPlayer(String playerName) {
		String newID = generatePlayerID();
		this.playerList.add(new Player(newID, playerName));
		System.out.println("Successfully added.");
	}

	
	// Writing contents of playerList to the txt file.
	public void writeToFile() {
		try {
			FileWriter writer = new FileWriter(Database.playerFile);
			String playerData = "", tempString = "";
			
				for(Player player: getPlayerList()) {
					
					//Check if got pokemon
					if(player.getPlayerPokemons() != null) {
						for(Pokemon pokemon : player.getPlayerPokemons()) {
							tempString = tempString.concat(pokemon.getPokemonName() + "-");
						}
						playerData = String.format("%s,%s,%s,%s,%s,%s\n", 
								player.getPlayerID(), 
								player.getPlayerName(), 
								player.getPlayerScore(),
								player.getPlayerBattlePlayed(),
								tempString.substring(0,tempString.length()-1),
								player.getPlayerMedal());
						
					}else {
						playerData = String.format("%s,%s,%s,%s,%s,%s\n", 
								player.getPlayerID(), 
								player.getPlayerName(), 
								player.getPlayerScore(),
								player.getPlayerBattlePlayed(),
								"null",
								player.getPlayerMedal());
					}
					
					writer.write(playerData);
					tempString = "";
				}

			
			
			writer.close();
			System.out.println("Data written to file successfully.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String generatePlayerID() {
		String lastPlayerID = getPlayerList().get(this.playerList.size()-1).getPlayerID();
		System.out.println(lastPlayerID);
		
		
		int id =  Integer.parseInt(lastPlayerID.substring(1)) + 1;
		String newPlayerID = String.format("P%03d", id);
		
		return newPlayerID;
	}

	
}	