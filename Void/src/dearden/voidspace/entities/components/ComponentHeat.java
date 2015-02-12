package dearden.voidspace.entities.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import dearden.voidspace.geom.Circle;

public class ComponentHeat extends Component {

	private float heatCapacity;
	private float currentHeatLevel;       //How hot something is from 0.0 to 1.0
	private Circle circleHeat;            //The radius of radiation.
	
	public ComponentHeat(float heatCapacity, float x, float y){
		this.heatCapacity = heatCapacity;
		this.makeCircle(x, y);
	}
	
	/*
	 * Functions start.
	 */
	
	
	public void makeCircle(float x, float y){
		circleHeat = new Circle(x, y, heatCapacity * currentHeatLevel);
	}
	
	/*
	 * Since players are able to customize their ships, I needed a simple
	 * way to change the level of heat signatures each ship will give off.
	 * The higher level weapons and upgrades, the higher the heatCapacity is.
	 * currentHeatLevel is the percentage of the heatCapacity which depends
	 * on how many of the ship's addons are currently turned on.
	 */
	@Override
	public void update(GameContainer gc, int delta){
		circleHeat.setRadius(heatCapacity * currentHeatLevel);
	}
	
	@Override
	public void handleMessage(ComponentType type, String message) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void cleanUp(){
		
	}
	
	public void setHeatLevel(float numAddons, float numActivated){
		currentHeatLevel = (numActivated * 100) / numAddons;
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

	@Override
	public void init(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		// TODO Auto-generated method stub
	}
}
