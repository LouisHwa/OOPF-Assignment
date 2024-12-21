package classes;

import java.util.Random;

public abstract class Environment {
	// attributes
	private String environtmentName;
	private String environtmentType;
	private String environmentElement;
	

	public Environment() {
		
	}
	
	public Environment(String environtmentName, String environtmentType, String environmentElement) {
		super();
		this.environtmentName = environtmentName;
		this.environtmentType = environtmentType;
		this.environmentElement = environmentElement;
	}
	
	

	public String getEnvirontmentName() {
		return environtmentName;
	}



	public void setEnvirontmentName(String environtmentName) {
		this.environtmentName = environtmentName;
	}



	public String getEnvirontmentType() {
		return environtmentType;
	}



	public void setEnvironementType(String environmentType) {
		this.environtmentType = environmentType;
	}

	public String getEnvironmentElement() {
		return environmentElement;
	}



	public void setEnvironmentElement(String environmentElement) {
		this.environmentElement = environmentElement;
	}


	@Override
	public String toString() {
		return String.format("Environment [environtmentName=%s, environtmentType=%s]", environtmentName,
				environtmentType);
	}

	 public static Environment environmentGenerator(String[] environments) {
			Environment currentEnvironment = null;
			Random random = new Random();
			int choice = random.nextInt(environments.length);
			String selectedEnvironment = environments[choice];
			
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

	//Apply buff
	public abstract void applyBuff(Pokemon pokemon);
	





	
}
