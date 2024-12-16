package classes;

import java.util.ArrayList;

public class testEnvironment {

	public static void main(String[] args) {
		ArrayList<String> environments = new ArrayList<>();
		environments.add("Jungle");
		environments.add("Ocean");
		environments.add("Volcano");
		environments.add("Desert");
		environments.add("Thunderstorm");
		
		//create object
		Jungle jungle = new Jungle();
		Ocean ocean = new Ocean();
		Volcano volcano = new Volcano();
		Desert desert = new Desert();
		Thunderstorm thunderstorm = new Thunderstorm();
		
		//create environment object
		Environment environmentManager = new Environment(environments, null, jungle, ocean, volcano, desert, thunderstorm);
		
		//random select an environment and apply its buff
		environmentManager.environmentGenerator();

	}

}
