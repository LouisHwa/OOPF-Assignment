package classes;
import java.util.Scanner;
import java.util.ArrayList;

public class Mainmenu {
    private String type;


    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private String loggedInPlayer = null; 

 
    public Mainmenu(String type) {
        this.type = type;
    }


    public void playerSignUp() {
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

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Validate credentials
        int index = usernames.indexOf(username);
        if (index != -1 && passwords.get(index).equals(password)) {
            loggedInPlayer = username;
            System.out.println("Login successful! Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }


    public void displayPlayerInformation() {
        System.out.println("\n--- Player Information ---");

        if (loggedInPlayer == null) {
            System.out.println("No player is currently logged in.");
        } else {
            System.out.println("Logged-in Player: " + loggedInPlayer);
            System.out.println("Type: " + type);
        }
    }

   
    public static void main(String[] args) {
        Mainmenu menu = new Mainmenu("Pokémon Adventure");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Display Player Information");
            System.out.println("4. Exit");

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
}

