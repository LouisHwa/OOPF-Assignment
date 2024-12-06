package classes;
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
	
//	toString
	@Override
	public String toString() {
		System.out.println("blah");
		return "PokemonBall [ballName=" + ballName + ", ballSuccessProbability=" + ballSuccessProbability
				+ ", ballAppearingProbability=" + ballAppearingProbability + "]";
	}
	
	
	
}