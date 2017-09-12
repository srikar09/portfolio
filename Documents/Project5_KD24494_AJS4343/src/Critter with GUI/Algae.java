package assignment5;

import assignment5.Critter.CritterShape;
/*
 * Do not change or submit this file.
 */
import assignment5.Critter.TestCritter;

public class Algae extends TestCritter {

	public String toString() { return "Algae"; }
	
	public boolean fight(String not_used) { return false; }
	
	public void doTimeStep() {
		setEnergy(getEnergy() + Params.photosynthesis_energy_amount);
	}

	@Override
	public CritterShape viewShape() {
 
		return CritterShape.CIRCLE;		
	}
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.GREEN; }

}
