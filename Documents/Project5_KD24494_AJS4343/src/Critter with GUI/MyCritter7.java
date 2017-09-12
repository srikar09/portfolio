package assignment5;

import assignment5.Critter.CritterShape;
import assignment5.Critter.TestCritter;

public class MyCritter7 extends TestCritter {
	
	@Override
	public void doTimeStep() {
	}

	@Override
	public boolean fight(String opponent) {

		return true;
	}

	@Override
	public String toString () {
		return "MyCritter7";
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.SQUARE;	
	}
	

	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.GREY; 
	}

}
