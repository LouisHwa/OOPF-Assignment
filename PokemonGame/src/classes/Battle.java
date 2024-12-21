package classes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    Database db = new Database();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Pokemon> pokelist = db.getPokemonList();
    ArrayList<Player> playerlist = db.getPlayerList();
    AsciiArt art = new AsciiArt();
    
    
    
    // Generates 3 starting pokemon if and only if the player is new.
    public Pokemon startingPokemon() {
    	db.readPokemonFile();
    	db.readPlayerFile();
		Pokemon decision = null;
		Pokemon sp1 = pokelist.get(5); //Charmander
		Pokemon sp2 = pokelist.get(17); //Bulbasur
		Pokemon sp3 = pokelist.get(11); //Squirtle
		System.out.println("======= Choose your starting pokemon =======");
		System.out.println("1.\n" + sp1.pokemonInfo());
		System.out.println("2.\n" + sp2.pokemonInfo());
		System.out.println("3.\n" + sp3.pokemonInfo());
		while (true){
			try {
				System.out.println("Enter your choice (1, 2, 3):  ");
				int choice = scanner.nextInt();
				
				switch(choice) {
					case 1:
						decision = sp1;
						break;
					case 2: 
						decision = sp2;
						break;
					case 3:
						decision = sp3;
						break;
					default:
						System.out.println("Enter only Integers between 1-3. ");
						continue;		
				}
				break;
			}catch(Exception e) {
				System.out.println("Enter only Integers between 1-3. ");
				scanner.nextLine();
			}
		}
		System.out.println("============================================");
		
		//Adds the chosen pokemon into the player db.
		return decision; // Returning the chosen Pokemon;
		// Add You have chosen "decision" as your first ever pokemon! in the 'game' driver class
	}
	
    
    
    // Generates 2 random wild pokemons
    public Pokemon[] wildPokemon() {
    	db.readPokemonFile();
    	db.readPlayerFile();
    	Random rand = new Random();
    	int randnum1 = rand.nextInt(30); //0-29, as pokemon only has 30.
    	int randnum2;
    	do {
    		randnum2 = rand.nextInt(30);
    	}while(randnum1 == randnum2);
		Pokemon wildPokemon1 = pokelist.get(randnum1);
		Pokemon wildPokemon2 = pokelist.get(randnum2);
		art.voiceSummoned();
		System.out.println("1.\n" + wildPokemon1.pokemonInfo());
		System.out.println("2.\n" + wildPokemon2.pokemonInfo());
		System.out.println("=====================================================\n");
		// Battle Begins
		return new Pokemon[] {wildPokemon1, wildPokemon2};
		// Returning as arrays for values
    }
   
    public Pokemon rentPokemom() {
    	ArrayList<Pokemon> tempList = new ArrayList<Pokemon>();
    	Random rand = new Random();
    	for (Pokemon pokemon : pokelist) {
    		if((int)pokemon.getPokemonRARITY() == 4) {
    			tempList.add(pokemon);
    		}
    	}
    	int randnum1 = rand.nextInt(tempList.size());
    	int randnum2;
    	do {
    		randnum2 = rand.nextInt(tempList.size());
    	}while(randnum1 == randnum2);
    	Pokemon rentedPokemon1 = tempList.get(randnum1);
    	Pokemon rentedPokemon2 = tempList.get(randnum2);
    	
    	while (true) {
    		try {
    			System.out.println("======= You can rent a pokemon of your choice! =======");
		    	System.out.println("1.\n" + rentedPokemon1.pokemonInfo());
				System.out.println("2.\n" + rentedPokemon2.pokemonInfo());
				System.out.println("======================================================");
				System.out.println("Choose one (1) of your choice: ");
				int choice = scanner.nextInt();
				switch(choice) {
					case 1:
						return rentedPokemon1;
					case 2:
						return rentedPokemon2;
					default:
						System.out.println("Please input an integer, [1] or [2]");
						continue; 
				}
    		}catch(Exception e) {
    			System.out.println("Please input an integer, [1] or [2]");
    			scanner.nextLine();
    		}
    	}
    	
		
    	// Returns only 2 rented pokemon.
    }

    public Pokemon[] chooseBattlePokemons(Player player) {
    	
    	while (true) {
    		try {
    			System.out.println("###############");
				player.displayPlayerPokemon();
				System.out.println("###############\n");
				
				if(player.getPlayerPokemons().size() <= 1) {
					return new Pokemon[] {player.getPlayerPokemons().get(0)};
				}
				
				System.out.println("Choose pokemon [1]: ");
				int choice1 = scanner.nextInt();
				Pokemon pokemon1 = player.getPlayerPokemons().get(choice1 - 1);
				
				System.out.println("Choose pokemon [2]: ");
				int choice2 = scanner.nextInt();
				Pokemon pokemon2 = player.getPlayerPokemons().get(choice2 - 1);
				
				if (choice1 != choice2 && choice1 >= 0 && choice1 < player.getPlayerPokemons().size()+1 && choice2 >= 0 && choice2 < player.getPlayerPokemons().size()+1) {
					return new Pokemon[] {pokemon1, pokemon2};
				}else {
					System.out.println("No duplicates and has has to be a valid pokemon");
					continue;
				}
    		}catch(Exception e) {
    			System.out.printf("Input an integer between 1 - %s.\n", player.getPlayerPokemons().size());
    			scanner.nextLine();
    		}
    	}
    }
    
    public Player battlingDynamic(Player currentPlayer, ArrayList<Pokemon> userPokemons, ArrayList<Pokemon> wildPokemons, Environment stadium) {
    	// Initializing all variables
    	int counter = 1; 
    	int score = 0, medal = 0;// Maximum winning of score is 3000 per round
    	Queue<Pokemon> team1 = new LinkedList<>(userPokemons);
    	Queue<Pokemon> team2 = new LinkedList<>(wildPokemons);
    	
    	if(stadium != null) {
    		stadium.applyBuff(userPokemons.get(0));
    		stadium.applyBuff(userPokemons.get(1));
    	}
    	
    	System.out.println("");
    	
    	// Choosing who attack first
    	boolean isturn = whosTurn();
    	System.out.println(isturn ? "You get to go First!" : "You're going Second!"); // true : false
			
    	// Attacking Dynamic
    	while(!team1.isEmpty() && !team2.isEmpty()) {
    		Pokemon attacker, defender;
    		
    		System.out.printf("=========================== Turn %s ===========================\n", counter);
        	
        	// if true, team1 against team2, else team2 against team1
    		if(isturn) {
    			attacker = team1.peek();	
    			defender = team2.peek();
    		}else {
    			attacker = team2.peek();
    			defender = team1.peek();
    		}
    		
        	
        	System.out.printf("%s sent out to fight agaisnt %s!\n",attacker.getPokemonName(), defender.getPokemonName());
        	
        	// Pokemon Attack
        	boolean ulti = attacker.checkZmove();
        	if(!ulti) {
        		attacker.Attack(attacker, defender);
        	}else {
        		attacker.ult(attacker, defender);
        	}
        	
        	System.out.println(defender.pokemonStats()); // Show the stats of the attacked pokemon
        	
        	if (defender.getPokemonHP() <= 0) {
        		defender.setPokemonHP(0);
        		System.out.printf("%s has fallen!\n", defender.getPokemonName());
        		team2.poll();
        	}
        	
        	if (attacker.getPokemonHP() <= 0) {
        		attacker.setPokemonHP(0);
        		System.out.printf("%s has fallen!\n", attacker.getPokemonName());
        		team1.poll();
        	}
        	System.out.printf("===============================================================\n\n");
       
        	
        	//Alternate the turns
        	isturn = !isturn;
        	counter++;
        	
    	}
    	if (team1.isEmpty()) {
    		art.wildWin(); // art
            score = 0;
            medal = 0;
        } else {
            art.youWin(); // art
            score = 10000 / (counter-1);
            medal = score / (counter+1);
        }    	
    	
    	art.battleEnd(); // art
        System.out.printf("Score increased! +%dpts\n", score);
        System.out.printf("Medal rewarded! +%d medals\n\n", medal);
    	currentPlayer.setPlayerScore(currentPlayer.getPlayerScore() + score);
		currentPlayer.setPlayerMedal(currentPlayer.getPlayerMedal() + medal);
		currentPlayer.setPlayerBattlePlayed(currentPlayer.getPlayerBattlePlayed() + 1);
		
		// Catch Pokemon If win
		if (!team1.isEmpty()) {
			art.catchPokemon();
			PokemonBall[] balls = {new Masterball(), new Ultraball(),new Greatball(), new Pokeball()};
			PokemonBall playerball = PokemonBall.ballGenerator(balls);
			System.out.println("You got a " + playerball.getBallName() + "!");
			System.out.println("Press [Enter] to catch both of the pokemons!");
			
			scanner.nextLine(); // Clears buffer
			scanner.nextLine(); // Now wait for user to enter
			
			// Checks if it containes that pokemon
			boolean gotornot1 = false, gotornot2 = false;
			for(Pokemon p : currentPlayer.getPlayerPokemons()) {
				if(p.getPokemonName().equals(wildPokemons.get(0).getPokemonName())) {
					gotornot1 = true;
				}
				
				if(p.getPokemonName().equals(wildPokemons.get(1).getPokemonName())) {
					gotornot2 = true;
				}
			}
			
			//Check the second one
			if(gotornot1 != true) {
				boolean caught1 = playerball.checkSuccess(wildPokemons.get(0), playerball);
				if(caught1) {
					playerball.caught(wildPokemons.get(0));
					db.updatePlayerPokemon(currentPlayer, wildPokemons.get(0));
				}else {
					playerball.escape(wildPokemons.get(0));
				}
			}else {
				System.out.printf("-- You've already gotten %s in your pokemon list --\n\n", wildPokemons.get(0).getPokemonName());
			}
		
			if(gotornot2 != true) {
				boolean caught2 = playerball.checkSuccess(wildPokemons.get(1), playerball);
				if(caught2) {
					playerball.caught(wildPokemons.get(1));
					db.updatePlayerPokemon(currentPlayer, wildPokemons.get(1));
				}else {
					playerball.escape(wildPokemons.get(1));
				}
			}else {
				System.out.printf("-- You've already gotten %s in your pokemon list --\n\n", wildPokemons.get(1).getPokemonName());
			}
		}
		
		
		db.writeToFile();
		displayTop5();
		return currentPlayer;
    }

    
    // Checking is it user or AI turn
    public boolean whosTurn() {
    	Random rand = new Random();
    	int userDiff = 0, aiDiff = 0;
		int middlenum = rand.nextInt(100) + 1; // number used to compare
		int randnum = rand.nextInt(100) + 1; // number used for AI
		System.out.println("To determine who go first.. ");
		System.out.println("Please Enter your guess between 1-100");
		int usernum = scanner.nextInt();
		
		// Get the user difference
		if(usernum >= middlenum) {
			userDiff = usernum - middlenum;
		}else if(middlenum >= usernum){
			userDiff = middlenum - usernum;
		}
		
		// Get the ai difference
		if(randnum >= middlenum) {
			aiDiff = randnum - middlenum;
		}else if(middlenum >= randnum){
			aiDiff = middlenum - randnum;
		}
		System.out.printf("Number: %s\n", middlenum);
		System.out.printf("Your Guess: %s\n", usernum);
		System.out.printf("AI Guess: %s\n\n", randnum);
		// Now compare with the two difference
		if(aiDiff >= userDiff) {
			return true; // True for giving user go first
		}else {
			return false; //
		}
    }
    
    public void displayTop5(){
    	db.readPokemonFile();
    	db.readPlayerFile();
    	int counter = 1;
    	art.leaderboard(); // art
		for(Player top5score: db.getTopFive()) {
			System.out.printf("%s. ID: %s, Score: %s, Medal: %s\n", counter,top5score.getPlayerID(),top5score.getPlayerScore(), top5score.getPlayerMedal());
			counter++;
		};
	}
    
    public Environment environmentGenerator() {
		String[] Environments = {"Jungle", "Ocean", "Volcano", "Desert", "ThunderStorm"};
		Environment currentEnvironment = null;
		Random random = new Random();
		int choice = random.nextInt(Environments.length);
		String selectedEnvironment = Environments[choice];
		
		switch (selectedEnvironment) {
			case "Jungle":
				currentEnvironment = new Jungle("Emerald Canopy", "Jungle", "Grass");
				break;
			case "Ocean":
				currentEnvironment = new Ocean("Azure Abyss", "Ocean", "Water");
				break;
			case "Volcano":
				currentEnvironment = new Volcano("Inferno Peak", "Volcano", "Fire");
				break;
			case "Desert":
				currentEnvironment = new Desert("Sunscorch Expanse", "Desert", "Ground");
				break;
			case "Thunderstorm":
				currentEnvironment = new Thunderstorm("Teampest Valley", "Thunderstorm", "Electric");
				break;				
		}
		return currentEnvironment;
	}
}
