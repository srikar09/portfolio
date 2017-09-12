package assignment5;

import java.util.*;

import assignment5.Critter.CritterShape;

//choses to stay  

public class Critter1 extends Critter.TestCritter {

	@Override
	public void doTimeStep() {
		walk(0);
	}   

	@Override
	public boolean fight(String opponent) {
		return false;
	}
	
	public String toString() {  
		return "Critter1";
	}
	
	public void test (List<Critter> l) {  
		
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.TRIANGLE;			
	}

	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.BLUE; 
	}
}