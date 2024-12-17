package classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class PokemonBall {
	//attributes
	private String ballName;
	private double ballSuccessProbability;
	private double ballAppearingProbability;

	//constructor
	public PokemonBall() {
		
	}
	
	public PokemonBall(String ballName, double ballSuccessProbability, double ballAppearingProbability) {
		this.ballName = ballName;
		this.ballSuccessProbability = ballSuccessProbability;
		this.ballAppearingProbability = ballAppearingProbability;
	}

	//setter/getter
	public String getBallName() {
		return ballName;
	}

	public void setBallName(String ballName) {
		this.ballName = ballName;
	}

	public double getBallSuccessProbability() {
		return ballSuccessProbability;
	}

	public void setBallSuccessProbability(double ballSuccessProbability) {
		this.ballSuccessProbability = ballSuccessProbability;
	}

	public double getBallAppearingProbability() {
		return ballAppearingProbability;
	}

	public void setBallAppearingProbability(double ballAppearingProbability) {
		this.ballAppearingProbability = ballAppearingProbability;
	}
	
	
//  other methods
	
	// ball generator
	public static PokemonBall ballGenerator(PokemonBall [] balls) {
		int rnd = new Random().nextInt(100) + 1;
		
		int[] randomBall = new int[balls.length];
		for (int i = 0; i < balls.length; i++) {
			randomBall[i] = (int) (balls[i].getBallAppearingProbability() * 100);
			if (rnd <= randomBall[i]) {
				
				return balls[i];
			}
		}
		return balls[balls.length - 1];

	}
	
	//catch success depending on ball success probability method
	public boolean checkSuccess(Pokemon pokemon, PokemonBall pokeballs) {
		int rnd = new Random().nextInt(100) + 1;
		double successR = pokeballs.getBallSuccessProbability() * (pokemon.getPokemonRARITY()/5);
		
		if(successR >= rnd) {
			//if use this need to change from boolean to String
//			return String.format("Your succesfully captured %s with your %s", pokemon.getPokemonName(), pokeballs.getBallName());
			return true;
			
		}else {
			return false;
		}
		
	}
	
	
	public void collect() {
		
	}

	
	//toString
	@Override
	public String toString() {
		return "PokemonBall [ballName=" + ballName + ", ballSuccessProbability=" + ballSuccessProbability
				+ ", ballAppearingProbability=" + ballAppearingProbability + "]";
	}

	
	
	
	
	

	
	
	
}