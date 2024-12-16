package classes;
import java.util.Random;
public class PokemonBall {
	//attributes
	private String ballName;
	private double ballSuccessProbability;
	private double ballAppearingProbability;

	//constructor
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
		int rnd = new Random().nextInt(100);
		
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
		
		if((pokemon.getPokemonRARITY() * pokeballs.getBallSuccessProbability()) > 1) {
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