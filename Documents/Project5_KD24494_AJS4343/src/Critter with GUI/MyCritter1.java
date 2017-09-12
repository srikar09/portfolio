package assignment5;

import java.util.*;

import assignment5.Critter.CritterShape;

public class MyCritter1 extends Critter.TestCritter {

	@Override
	public void doTimeStep() {
		walk(0);
	}   

	@Override
	public boolean fight(String opponent) {
		if (getEnergy() > 10) return true;
		return false;
	}
	
	public String toString() {  
		return "MyCritter1";
	}
	
	public void test (List<Critter> l) {  
		
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.SQUARE;			
	}
}
