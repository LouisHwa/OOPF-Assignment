package classes;

import java.util.ArrayList;

public class Desert extends Environment{
	public Desert() {
		super(new ArrayList<String>(), "Desert", null, null, null, null, null);
	}
	
	public void ApplyBuff() {
		System.out.println("Buff applied for Desert: Sand Buff");
	}

}
