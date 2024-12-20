package classes;

public class Volcano extends Environment{
	

	public Volcano(String environtmentName, String environementType) {
		super(environtmentName, environementType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Fire")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 20);
			System.out.printf("Volcano buff applied! ATK increased by 20 on %s!\n", pokemon.getPokemonName());
		} else {
			System.out.printf("Environment has no effect on %s!\n", pokemon.getPokemonName());
		}

	}
	
	@Override
    public String getEnvironmentType() {
        return "Fire";
    }
	
}
