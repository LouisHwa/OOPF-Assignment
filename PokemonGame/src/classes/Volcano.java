package classes;

public class Volcano extends Environment{
	
	public Volcano(String environtmentName, String environtmentType, String environmentElement) {
		super(environtmentName, environtmentType, environmentElement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals(this.getEnvironmentElement())) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 20);
			System.out.printf("Volcano buff applied! ATK increased by 20 on %s!\n", pokemon.getPokemonName());
		} else {
			System.out.printf("Environment has no effect on %s!\n", pokemon.getPokemonName());
		}

	}
	
}
