package assignment5;

import java.util.*;

import assignment5.Critter.CritterShape;

//choses to fight or stay based on energy 

public class Critter4 extends Critter.TestCritter {

	@Override
	public void doTimeStep() {
		walk(0);
	}   

	@Override
	public boolean fight(String opponent) {
		if (getEnergy() > 1) return true;
		return false;
	}
	
	public String toString() {  
		return "Critter4";
	}
	
	public void test (List<Critter> l) {  
		
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.DIAMOND;		
	}
	
	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.BLACK; 
	}
	
}