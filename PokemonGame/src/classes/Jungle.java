package classes;

public class Jungle extends Environment{
	
	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Grass")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 10);
			System.out.println("Grass buff applied! ATK increased by 10. New ATK: " + pokemon.getPokemonATK());
		} 
		else {
			System.out.println("No buff applied! Pokemon type does not match Grass environmet");
		}
	}
	
	@Override
    public String getEnvironmentType() {
        return "Grass";
    }
	
}
