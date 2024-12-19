package classes;

public class Thunderstorm extends Environment{
	
	@Override
	public void applyBuff(Pokemon pokemon) {
		if (pokemon.getPokemonType().equals("Electric")) {
			pokemon.setPokemonATK(pokemon.getPokemonATK() + 10);
			System.out.println("Thunderstorm buff applied! ATK increased by 10. New ATK: " + pokemon.getPokemonATK());
		} 
		else {
			System.out.println("No buff applied! Pokemon type does not match Thunderstorm environmet");
		}
	}
	
	@Override
    public String getEnvironmentType() {
        return "Electric";
    }
}
