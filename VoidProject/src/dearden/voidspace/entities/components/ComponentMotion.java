package dearden.voidspace.entities.components;

import dearden.voidspace.geom.Vector;
import dearden.voidspace.systems.Game;

public class ComponentMotion extends Component {

	private int deltaStore = 0;
	private float maxSpeed;
	private float accel;
	private Vector accelTick;
	private Vector modAccelTick;
	private Vector currentVector;

	public ComponentMotion(float maxSpeed, float accel){
		this.type = ComponentType.MOTION;
		this.maxSpeed = maxSpeed;
		this.accel = accel;
	}
	
	/*
	 * Required Functions start.
	 */
	@Override
	public void init(){
		currentVector = new Vector(parent.getX(), parent.getY(), 0, 0);
		accelTick = new Vector(parent.getX(), parent.getY(), 0, accel);
	}
	
	@Override
	public void update(float delta){
		currentVector.setPos(currentVector.endPoint());
		parent.setCenterX(currentVector.getX());
		parent.setCenterY(currentVector.getY());
	}
	
	@Override
	public void handleMessage(ComponentType type, String message){
		// TODO 
	}
	
	@Override
	public void cleanUp(){
		// TODO
	}
	
	/*
	 * Functions start.
	 */
	public void addVector(Vector other){
		this.currentVector = this.currentVector.add(other);
	}
	
	public void addAccelInDirection(float direction, float delta){
		accelTick.setDirection(direction);
		this.currentVector = this.currentVector.add(accelTick);
		if(currentVector.getMagnitude() > maxSpeed){
			currentVector.setMagnitude(maxSpeed);
		}
	}
	
	/*
	 * GET Functions Start
	 */
	public Vector getCurrentVector(){
		return currentVector;
	}
}
