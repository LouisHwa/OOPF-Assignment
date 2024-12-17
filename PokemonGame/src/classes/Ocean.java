package classes;

public class Ocean extends Environment{
	
	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Water")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 10);
			System.out.println("Ocean buff applied! ATK increased by 10. New ATK: " + pokemon.getPokemonATK());
		} 
		else {
			System.out.println("No buff applied! Pokemon type does not match Ocean environmet");
		}
	}
	
	@Override
    public String getEnvironmentType() {
        return "Water";
    }
}
