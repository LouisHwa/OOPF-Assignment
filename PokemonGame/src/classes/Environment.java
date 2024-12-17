package classes;

import java.util.Random;

public abstract class Environment {
	// attributes
	private static String[] Environments = {"Jungle", "Ocean", "Volcano", "Desert", "ThunderStorm"};
	private static Environment currentEnvironment;

	private Jungle jungle;
	private Ocean ocean;
	private Volcano volcano;
	private Desert desert;
	private Thunderstorm thunderstorm;

	// setters/getters
	public Jungle getJungle() {
		return jungle;
	}

	public void setJungle(Jungle jungle) {
		this.jungle = jungle;
	}

	public Ocean getOcean() {
		return ocean;
	}

	public void setOcean(Ocean ocean) {
		this.ocean = ocean;
	}

	public Volcano getVolcano() {
		return volcano;
	}

	public void setVolcano(Volcano volcano) {
		this.volcano = volcano;
	}
	
	public Desert getDesert() {
		return desert;
	}

	public void setDesert(Desert desert) {
		this.desert = desert;
	}

	public Thunderstorm getThunderstorm() {
		return thunderstorm;
	}

	public void setThunderstorm(Thunderstorm thunderstorm) {
		this.thunderstorm = thunderstorm;
	}
	
	//Apply buff
	public abstract void applyBuff(Pokemon pokemon);
	
	//Get the environment type (match with pokemonType)
	public abstract String getEnvironmentType();

	//other method
	//Method to select a random environment
	public static Environment environmentGenerator() {
		Random random = new Random();
		int choice = random.nextInt(Environments.length);
		String selectedEnvironment = Environments[choice];
		
		switch (selectedEnvironment) {
			case "Jungle":
				currentEnvironment = new Jungle();
				break;
			case "Ocean":
				currentEnvironment = new Ocean();
				break;
			case "Volcano":
				currentEnvironment = new Volcano();
				break;
			case "Desert":
				currentEnvironment = new Desert();
				break;
			case "Thunderstorm":
				currentEnvironment = new Thunderstorm();
				break;				
		}
		
		System.out.println("Current Environment: " + selectedEnvironment);
		return currentEnvironment;
		
	}
	
}
