package classes;

public class Thunderstorm extends Environment{
	


	public Thunderstorm(String environtmentName, String environtmentType, String environmentElement) {
		super(environtmentName, environtmentType, environmentElement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals(this.getEnvironmentElement())) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 20);
			System.out.printf("Thunderstorm buff applied! ATK increased by 20 on %s!\n", pokemon.getPokemonName());
		} else {
			System.out.printf("Environment has no effect on %s!\n", pokemon.getPokemonName());
		}
	}

}
