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
		double rnd = new Random().nextDouble();
		
		double[] randomBall = new double[balls.length];
		for (int i = 0; i < balls.length; i++) {
			randomBall[i] = balls[i].getBallAppearingProbability();
			if (rnd <= randomBall[i]) {
				return balls[i];
			}
		}
		
		return balls[balls.length - 1];
	}
	
//	toString
	@Override
	public String toString() {
		return "PokemonBall [ballName=" + ballName + ", ballSuccessProbability=" + ballSuccessProbability
				+ ", ballAppearingProbability=" + ballAppearingProbability + "]";
	}
	
	
	
}