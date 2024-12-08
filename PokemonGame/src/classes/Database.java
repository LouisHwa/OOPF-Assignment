package classes;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

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
	
	// Reads all the details in pokemon file and stored in pokemonList
	public void readPokemonFile() {
		try {
			Scanner reader = new Scanner(Database.pokemonFile);
			while(reader.hasNextLine()) {
				String lines = reader.nextLine();
				String[] pokemonDetails = lines.split(",");
				Pokemon pokemon = new Pokemon(pokemonDetails[0], pokemonDetails[1], pokemonDetails[2], 
						Integer.parseInt(pokemonDetails[3]), Integer.parseInt(pokemonDetails[4]), Integer.parseInt(pokemonDetails[5]),
						pokemonDetails[6], Integer.parseInt(pokemonDetails[7]), Integer.parseInt(pokemonDetails[8]), 
						pokemonDetails[9], Double.parseDouble(pokemonDetails[10]));
				
				this.pokemonList.add(pokemon);		
			};
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void readPlayerFile() {
		try {
			Scanner reader = new Scanner(Database.playerFile);
			while(reader.hasNextLine()) {
				String lines = reader.nextLine();
				String[] playerDetails = lines.split(",");
				Player player = new Player(playerDetails[0], playerDetails[1], Integer.parseInt(playerDetails[2]), 
						Integer.parseInt(playerDetails[3]), getPlayerPokemons(playerDetails[4]), Integer.parseInt(playerDetails[5]));
			};
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Player> getTopFive(){
		ArrayList<Player> topFive = new ArrayList<Player>();
		
		
		return topFive;
		
	}
	
	public ArrayList<Pokemon> getPlayerPokemons(String playerID){
		ArrayList<Pokemon> playerOwnedPokemons = new ArrayList<Pokemon>();
		try {
			Scanner reader = new Scanner(Database.playerFile);
			while(reader.hasNextLine()){
				String lines = reader.nextLine();
				String[] playerDetails = lines.split(",");
				if(playerDetails[0].equals(playerID)) {
					String[] tempList = playerDetails[4].split("-");
					for(String pokemon: tempList) {
						int index = 0;
						for(int i = 0; i < pokemonList.size(); i++) {
							if (pokemonList.get(i).getPokemonName().equals(pokemon)) {
								index = 1;
								break;
							}
						}
						if(index != 0) {
							playerOwnedPokemons.add(pokemonList.get(index));
						}
						
					}
					
				}
			}
			reader.close();
			return playerOwnedPokemons;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	// Need to find a way to extract the pokemon details and stored it in an array.
	// Extract all the pokemons into the list array, line by line. 
	// Then create a method to extract the pokemonDetails by splitting ','. Can acccept the input by pokemon 'ID'.
	// After splitting, the function will return each values with a given name
}	