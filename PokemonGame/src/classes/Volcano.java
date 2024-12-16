package classes;

import java.util.ArrayList;

public class Volcano extends Environment{
	
	public Volcano() {
		super(new ArrayList<String>(), "Volcano", null, null, null, null, null);
	}
	
	public void ApplyBuff() {
		System.out.println("Buff applied for Volcano: Heat Buff");
	}

}
