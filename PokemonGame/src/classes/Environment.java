package classes;

public abstract class Environment {
	// attributes
	private String environtmentName;
	private String environementType;
	

	/**
	 * @param environtmentName
	 * @param environementType
	 */
	public Environment(String environtmentName, String environementType) {
		super();
		this.environtmentName = environtmentName;
		this.environementType = environementType;
	}
	
	

	public String getEnvirontmentName() {
		return environtmentName;
	}



	public void setEnvirontmentName(String environtmentName) {
		this.environtmentName = environtmentName;
	}



	public String getEnvironementType() {
		return environementType;
	}



	public void setEnvironementType(String environementType) {
		this.environementType = environementType;
	}



	@Override
	public String toString() {
		return String.format("Environment [environtmentName=%s, environementType=%s]", environtmentName,
				environementType);
	}



	//Apply buff
	public abstract void applyBuff(Pokemon pokemon);
	
	//Get the environment type (match with pokemonType)
	public abstract String getEnvironmentType();
	
}
