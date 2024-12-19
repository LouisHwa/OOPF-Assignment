package classes;

public class Volcano extends Environment{
	
	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Fire")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 10);
			System.out.println("Volcano buff applied! ATK increased by 10. New ATK: " + pokemon.getPokemonATK());
		} 
		else {
			System.out.println("No buff applied! Pokemon type does not match Volcano environmet");
		}
	}
	
	@Override
    public String getEnvironmentType() {
        return "Fire";
    }
	
}
