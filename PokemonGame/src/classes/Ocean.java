package classes;

import java.util.ArrayList;

public class Ocean extends Environment{
	
	public Ocean() {
		super(new ArrayList<String>(), "Ocean", null, null, null, null, null);
	}
	
	public void ApplyBuff() {
		System.out.println("Buff applied for Ocean: Water Buff!");
	}

}
