package classes;

public class Ocean extends Environment{
	


	public Ocean(String environtmentName, String environementType) {
		super(environtmentName, environementType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Water")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 20);
			System.out.printf("Ocean buff applied! ATK increased by 20 on %s!\n", pokemon.getPokemonName());
		} else {
			System.out.printf("Environment has no effect on %s!\n", pokemon.getPokemonName());
		}
	}
	
	@Override
    public String getEnvironmentType() {
        return "Water";
    }
}
