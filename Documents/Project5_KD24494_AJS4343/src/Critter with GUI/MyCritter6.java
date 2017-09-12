package assignment5;

import assignment5.Critter.CritterShape;
import assignment5.Critter.TestCritter;

public class MyCritter6 extends TestCritter {
	
	@Override
	public void doTimeStep() {
	}

	@Override
	public boolean fight(String opponent) {
		run(getRandomInt(8));
		return false;
	}

	@Override
	public String toString () {
		return "MyCritter6";
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.STAR;	
	}
	
	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.PINK; 
	}
}
