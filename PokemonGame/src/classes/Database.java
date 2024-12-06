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
	private File pokemonFile;
	private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	
	
	public File getPokemonFile() {
		return this.pokemonFile;
		
	}
	
	public ArrayList<Pokemon> getPokemonList(){
		return this.pokemonList;
	}
	
	
	// Need to find a way to extract the pokemon details and stored it in an array.
	// Extract all the pokemons into the list array, line by line. 
	// Then create a method to extract the pokemonDetails by splitting ','. Can acccept the input by pokemon 'ID'.
	// After splitting, the function will return each values with a given name
}	