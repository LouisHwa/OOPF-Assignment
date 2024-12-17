package classes;

public class Desert extends Environment{

	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Ground")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 10);
			System.out.println("Desert buff applied! ATK increased by 10. New ATK: " + pokemon.getPokemonATK());
		} 
		else {
			System.out.println("No buff applied! Pokemon type does not match Desert environmet");
		}
	}
	
	@Override
    public String getEnvironmentType() {
        return "Ground";
    }
}
