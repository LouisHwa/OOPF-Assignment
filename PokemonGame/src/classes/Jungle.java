package classes;

import java.util.ArrayList;

public class Jungle extends Environment{
	public Jungle() {
		super(new ArrayList<String>(), "Jungle", null, null, null, null, null);
	}
	
	public void ApplyBuff() {
		System.out.println("Buff applied for Jungle: Green Buff");
	}
	
	
}
