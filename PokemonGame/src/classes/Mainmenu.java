package classes;
import java.util.Scanner;
import java.util.ArrayList;

public class Mainmenu {
<<<<<<< HEAD
    private String type;
=======
    // Field: type (used to represent the menu type or category)
//    private String type;
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment


    private ArrayList<String> usernames = new ArrayList<>();
<<<<<<< HEAD
    private ArrayList<String> passwords = new ArrayList<>();
    private String loggedInPlayer = null; 

 
    public Mainmenu(String type) {
        this.type = type;
=======
    private ArrayList<String> pIDs = new ArrayList<>();
    private int loggedInPlayerIndex; // Track the currently logged-in player
    private Player loggedInPlayer;
    Database db = new Database();
    Scanner scanner = new Scanner(System.in);
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
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment
    }

<<<<<<< HEAD

=======
	// Method for player sign-up (type in the name will do, then generate ID for them,  no need password
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment
    public void playerSignUp() {
<<<<<<< HEAD
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Player Sign-Up ---");

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();


        if (usernames.contains(username)) {
            System.out.println("Username already exists! Try a different one.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

  
        usernames.add(username);
        passwords.add(password);
        System.out.println("Sign-up successful! You can now log in.");
    }

 
    public void playerLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Player Login ---");
=======
        System.out.println("\n=======  ____  _                         ____  _                   _   _       \r\n"
        		+ "|  _ \\| | __ _ _   _  ___ _ __  / ___|(_) __ _ _ __       | | | |_ __  \r\n"
        		+ "| |_) | |/ _` | | | |/ _ \\ '__| \\___ \\| |/ _` | '_ \\ _____| | | | '_ \\ \r\n"
        		+ "|  __/| | (_| | |_| |  __/ |     ___) | | (_| | | | |_____| |_| | |_) |\r\n"
        		+ "|_|   |_|\\__,_|\\__, |\\___|_|    |____/|_|\\__, |_| |_|      \\___/| .__/ \r\n"
        		+ "               |___/                     |___/                  |_|     =======");
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment

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
       
		System.out.println("\n==========  ____  _                         _                _       \r\n"
				+ "|  _ \\| | __ _ _   _  ___ _ __  | |    ___   __ _(_)_ __  \r\n"
				+ "| |_) | |/ _` | | | |/ _ \\ '__| | |   / _ \\ / _` | | '_ \\ \r\n"
				+ "|  __/| | (_| | |_| |  __/ |    | |__| (_) | (_| | | | | |\r\n"
				+ "|_|   |_|\\__,_|\\__, |\\___|_|    |_____\\___/ \\__, |_|_| |_|\r\n"
				+ "               |___/                        |___/          ==========");

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
<<<<<<< HEAD
    }


    public void displayPlayerInformation() {
        System.out.println("\n--- Player Information ---");

        if (loggedInPlayer == null) {
            System.out.println("No player is currently logged in.");
        } else {
            System.out.println("Logged-in Player: " + loggedInPlayer);
            System.out.println("Type: " + type);
=======
        else {
        	System.out.println("Invalid username or playerID. Please try again.");
        	System.out.println("==================================\n");
    		return false;
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment
        }
   }
        	
        
    

    // Method to display player information -- NEED TO CHANGE


<<<<<<< HEAD
   
    public static void main(String[] args) {
        Mainmenu menu = new Mainmenu("Pokémon Adventure");
        Scanner scanner = new Scanner(System.in);
=======
    // Main method to demonstrate the Main Menu
	public int viewMainMenu(){		
		while (true) {
	        System.out.println("===========  __  __       _         __  __                  \r\n"
	        		+ "|  \\/  | __ _(_)_ __   |  \\/  | ___ _ __  _   _ \r\n"
	        		+ "| |\\/| |/ _` | | '_ \\  | |\\/| |/ _ \\ '_ \\| | | |\r\n"
	        		+ "| |  | | (_| | | | | | | |  | |  __/ | | | |_| |\r\n"
	        		+ "|_|  |_|\\__,_|_|_| |_| |_|  |_|\\___|_| |_|\\__,_| ==========");
	        System.out.println("1. Sign Up");
	        System.out.println("2. Login");
	        System.out.println("3. Exit");
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment

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

<<<<<<< HEAD
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    menu.playerSignUp();
                    break;
                case 2:
                    menu.playerLogin();
                    break;
                case 3:
                    menu.displayPlayerInformation();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
=======
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
    
	
>>>>>>> branch 'main' of https://github.com/LouisHwa/OOPF-Assignment
}

