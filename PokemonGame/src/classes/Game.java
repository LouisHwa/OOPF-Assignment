package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Mainmenu menu = new Mainmenu();
		Database db = new Database();
		Battle battle = new Battle();
		AsciiArt art = new AsciiArt();
		ArrayList<Player> playerList = db.getPlayerList();
		int currentPlayerIndex;
		Player currentPlayer;
		

		//Display MainView
		while (true) {
				db.readPokemonFile();
				db.readPlayerFile();
				
			try{
				int menuChoice = menu.viewMainMenu();
				switch (menuChoice) {
				
					// User choose to create account 
		            case 1:
		            	System.out.println();
		                menu.playerSignUp();
		                break;
		                
		                
		            // User chooses to log in 
		            case 2:
		                if(!menu.playerLogin()) {
		                	continue;
		                };
		                
		                //Function after player successfully logged in
		                while (true) {
		                	currentPlayerIndex = menu.getLoggedInPlayerIndex();
		                	currentPlayer = playerList.get(currentPlayerIndex);
		                	
		                	try {
		                		int logInChoice = menu.viewLoggedInMenu();
		                		switch(logInChoice){
		                		
			                		// Display player's information
			                		case 1: 
			                			currentPlayer.displayPlayerInformation();
			                			break;
			                			
			                		// Battle & Catch
			                		case 2:
			                			// Creating a temporary ArrayList of pokemon for a fight!
			                			ArrayList<Pokemon> battlePokemons = new ArrayList<Pokemon>();
			                			ArrayList<Pokemon> battleWildPokemons = new ArrayList<Pokemon>();
			                			
			                			art.welcomeBattleandCatch(); // art
			                			// Checks if player has a pokemon
			                			if(currentPlayer.getPlayerPokemons() == null) {
			                				Pokemon chosenP = battle.startingPokemon();
			                				db.updatePlayerPokemon(currentPlayer, chosenP);
			                	
			 
			                				// Display chosen pokemon Message
			                				System.out.printf("You've chosen %s!\n\n", chosenP.getPokemonName());
			                			}
			                			
			                			// Pokemon Roaring Message
			                			System.out.printf("In the wild, they heard you're voice...\n");
			                			Pokemon[] wildPokemons = battle.wildPokemon();
			                			battleWildPokemons.add(wildPokemons[0]);
			                			battleWildPokemons.add(wildPokemons[1]);
			                			
			                			
			                			System.out.println("To fight them, please choose (2) of your pokemon.");
			                			System.out.println("**Note: Sequence of choosing pokemons matter. \n");
			                			Pokemon[] chosenPokemons = battle.chooseBattlePokemons(currentPlayer);
			                			if(chosenPokemons.length == 1) {
			                				battlePokemons.add(chosenPokemons[0]);
			                			} else {
			                				battlePokemons.add(chosenPokemons[0]);
			                				battlePokemons.add(chosenPokemons[1]);
			                			}
			                			
			                			
			                			// If player have no more than 2 pokemons, allow them to rent a 4 star pokemon
			                			if(currentPlayer.getPlayerPokemons().size() < 2) {
			                				System.out.println("OH NOO! Looks like you only have 1 pokemon! Don't you worry.\n");
			                				Pokemon rentPokemon = battle.rentPokemom();
			                				System.out.printf("Nice! You've chosen %s as your rent pokemon.\n", rentPokemon.getPokemonName());
			                				battlePokemons.add(rentPokemon); //This makes up the total of 2 pokemons for battle
			                			}
			                			
			                			// Battle Begins
			                			System.out.println("\n=====================================================");
			                			System.out.printf("Your Battle Pokemons: %s, %s\n", battlePokemons.get(0).getPokemonName(), battlePokemons.get(1).getPokemonName());
			                			System.out.printf("Up against: %s, %s\n", battleWildPokemons.get(0).getPokemonName(), battleWildPokemons.get(1).getPokemonName());
			                			System.out.println("=====================================================\n");
			                			
			                			
			                			
			                			Environment stadium = battle.environmentGenerator();
			                			if(stadium != null) {
			                				System.out.printf("Looks like they flew to %s, a %s!!\n", stadium.getEnvirontmentName(), stadium.getEnvirontmentType());
			                			}else {
			                				System.out.println("Looks like they won't be going anywhere.. No Special Environment..\n");
			                			}
			                			

			                			currentPlayer = battle.battlingDynamic(currentPlayer, battlePokemons, battleWildPokemons, stadium);
			                
			  
			                	
			                			
			                			//Display the top5 after each game
			                			
			                			break;
			                			
			                		// Top Players
			                		case 3: 
			                			battle.displayTop5();
			                			break;
			                		
			                		// Log Out
			                		case 4:
			                			System.out.println("Logging Out...\n");
			                			break;
			                			
			                		default:
			                			System.out.println("Invalid choice. Please try again.");
			                		}
		                		
		                		 if (logInChoice == 4) {
		                             break; // Exits the inner loop and goes back to the main menu
		                         }
		                	}catch(Exception e) {
		                		System.out.println("Invalid Input! Logged In calls. ");
		                		System.out.println(e);
		        				scanner.nextLine();
		                	}
		                }
		                
		                continue;
		                
		                
					// User choose to exit the console
		            case 3:
		                art.goodBye();
		            	scanner.close();
		                return;
		            default:
		                System.out.println("Invalid choice. Please try again.");
					}
			}catch(Exception e) {
				System.out.println("Invalid Input! Main calls. ");
				scanner.nextLine();
			}
		}

	}

}
