package classes;

import java.util.ArrayList;

public class Thunderstorm extends Environment{
	
	public Thunderstorm() {
		super(new ArrayList<String>(), "Thunderstorm", null, null, null, null, null);
	}
	
	public void ApplyBuff() {
		System.out.println("Buff applied for Thunderstorm: Electric Buff");
	}

}
