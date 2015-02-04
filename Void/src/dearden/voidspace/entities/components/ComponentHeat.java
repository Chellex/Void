package dearden.voidspace.entities.components;

import dearden.voidspace.geom.Circle;

public class ComponentHeat extends Component {

	private float heatLevel;       //How hot something is from 0.0 to 1.0
	private Circle circleHeat;     //The radius of radiation.
	
	public ComponentHeat(float heatLevel){
		this.heatLevel = heatLevel;
	}
	
	/*
	 * Functions start.
	 */
	
	/*
	 * GET Functions.
	 */
	public float getHeatLevel(){
		return heatLevel;
	}
}
