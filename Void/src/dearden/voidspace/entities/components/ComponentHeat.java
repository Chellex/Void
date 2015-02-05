package dearden.voidspace.entities.components;

import dearden.voidspace.geom.Circle;

public class ComponentHeat extends Component {

	private float heatCapacity;
	private float currentHeatLevel;       //How hot something is from 0.0 to 1.0
	private Circle circleHeat;     //The radius of radiation.
	
	public ComponentHeat(float heatCapacity){
		this.heatCapacity = heatCapacity;
	}
	
	/*
	 * Functions start.
	 */
	public void init(float x, float y){
		circleHeat = new Circle(x, y, heatCapacity * currentHeatLevel);
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void cleanUp(){
		
	}
	
	/*
	 * GET Functions.
	 */
	public float getHeatLevel(){
		return currentHeatLevel;
	}
	
	public float getDetectionRadius(){
		return circleHeat.getRadius();
	}
}
