package classes;

import java.util.ArrayList;
import java.util.Random;

public class Environment {
	// attributes
	private ArrayList<String> Environments = new ArrayList<String>();
	private String CurrentEnvironment;

	private Jungle jungle;
	private Ocean ocean;
	private Volcano volcano;
	private Desert desert;
	private Thunderstorm thunderstorm;
	

	// constructor
	public Environment(ArrayList<String> environments, String currentEnvironment, Jungle jungle, Ocean ocean,
			Volcano volcano, Desert desert, Thunderstorm thunderstorm) {
		super();
		Environments = environments;
		CurrentEnvironment = currentEnvironment;
		this.jungle = jungle;
		this.ocean = ocean;
		this.volcano = volcano;
		this.desert = desert;
		this.thunderstorm = thunderstorm;
	}

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

	//Method to select a random environment
	public void environmentGenerator() {
		Random random = new Random();
		int choice = random.nextInt(Environments.size());
		CurrentEnvironment = Environments.get(choice);
		
		System.out.println("Selected Environment: " + CurrentEnvironment);
		
		//Apply buff on the selected environment
		switch (CurrentEnvironment) {
			case "Jungle":
				jungle.ApplyBuff();
				break;
			case "Ocean":
				ocean.ApplyBuff();
				break;
			case "Volcano":
				volcano.ApplyBuff();
				break;
			case "Desert":
				desert.ApplyBuff();
				break;
			case "Thunderstorm":
				thunderstorm.ApplyBuff();
				break;
			default:
				System.out.println("No environment selected.");
		}
		
	}
	
}
