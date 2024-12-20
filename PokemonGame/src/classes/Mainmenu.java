package classes;
import java.util.Scanner;
import java.util.ArrayList;

public class Mainmenu {
  
	// Lists to store the player credentials
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> pIDs = new ArrayList<>();
    private int loggedInPlayerIndex; // Track the currently logged-in player
    private Player loggedInPlayer;
    Database db = new Database();
    Scanner scanner = new Scanner(System.in);
    AsciiArt art = new AsciiArt();
   
    // Constructor to initialize the Main Menu
	public Player getLoggedInPlayer() {
		return loggedInPlayer;
	}



	public void setLoggedInPlayer(Player loggedInPlayer) {
		this.loggedInPlayer = loggedInPlayer;
	}



	public int getLoggedInPlayerIndex() {
		return loggedInPlayerIndex;
	}



	public void setLoggedInPlayerIndex(int loggedInPlayerIndex) {
		this.loggedInPlayerIndex = loggedInPlayerIndex;
	}

	public void populateCredentials() {
    	db.readPlayerFile();
		db.readPokemonFile();
    	for(Player player : db.getPlayerList()) {
    		pIDs.add(player.getPlayerID().toUpperCase());
    		usernames.add(player.getPlayerName().toLowerCase());
    	}
	}

	// Method for player sign-up (type in the name will do, then generate ID for them,  no need password
	 public void playerSignUp() {
	        art.playerSignUp(); // art

	        System.out.print("Enter your username: ");
	        String username = scanner.nextLine();

	    	usernames.add(username);
	    	String newID = db.addPlayer(username);
	    	pIDs.add(newID);
	    	db.writeToFile();
	    	System.out.printf("Sign-up successful! Your player ID: %s... You can now log in.\n\n", newID);
	    
	 }

    // Method for player login
    public boolean playerLogin() {
    	populateCredentials();
    	db.readPokemonFile();
		db.readPlayerFile();
		ArrayList<Player> playerList = db.getPlayerList();
       
		art.playerLogIn(); // art
		System.out.print("Enter your PlayerID: ");
        String pID = scanner.nextLine();
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        // Validate credentials
        int index = usernames.indexOf(username.toLowerCase());
        if (index != -1 && pIDs.get(index).equals(pID.toUpperCase())) {
        	
        	// Set Logged in player
        	for (int i = 0; i < playerList.size(); i++) {
        	    Player player = playerList.get(i); 
        	    if (player.getPlayerID().equals(pID.toUpperCase())) {
        	        setLoggedInPlayerIndex(i);
        	        setLoggedInPlayer(player);
        	        break; 
        	    }
        	}
            
            System.out.println("Login successful! Welcome, " + loggedInPlayer.getPlayerName() + "!");
            System.out.println("==================================\n");
            return true;
        }
        else {
        	System.out.println("Invalid username or playerID. Please try again.");
        	System.out.println("==================================\n");
    		return false;

        }
    }

    // Main method to demonstrate the Main Menu
	public int viewMainMenu(){		
		while (true) {
			art.mainMenuArt(); // art
	        System.out.println("1. Sign Up");
	        System.out.println("2. Login");
	        System.out.println("3. Exit");
	        
	        System.out.print("Choose an option: ");
	      
	        if (scanner.hasNextInt()) {
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            return choice;
	        } else {
	            System.out.println("Invalid Input! Please enter a number.\n");
	            scanner.nextLine(); // Clear the invalid input from the buffer
	        }
	    }
	}
	
	public int viewLoggedInMenu() {
		while (true) {
			System.out.printf("======= Welcome Back, %s! =======\n", loggedInPlayer.getPlayerName());
	        System.out.println("1. Player's Information");
	        System.out.println("2. Battle & Catch");
	        System.out.println("3. Top Players");
	        System.out.println("4. Log Out");
	        
	        System.out.print("Choose an option: ");
	        if (scanner.hasNextInt()) {
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            return choice;
	        } else {
	            System.out.println("Invalid Input! Please enter a number.\n");
	            scanner.nextLine(); // Clear the invalid input from the buffer
	        }
		}
	}
    
}

