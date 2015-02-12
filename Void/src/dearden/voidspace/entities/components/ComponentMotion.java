package dearden.voidspace.entities.components;

import org.newdawn.slick.GameContainer;

import dearden.voidspace.geom.Vector;
import dearden.voidspace.systems.Game;

public class ComponentMotion extends Component {

	private int deltaStore = 0;
	private float maxSpeed;
	private float accel;
	private Vector accelTick;
	private Vector currentVector;

	public ComponentMotion(float maxSpeed, float accel){
		this.type = ComponentType.MOTION;
		this.maxSpeed = maxSpeed;
		this.accel = accel;
	}
	
	@Override
	public void update(GameContainer gc, int delta){	
		deltaStore += delta;
		
		if(deltaStore > Game.TICK)
		{
			deltaStore = 0;
			
			currentVector.setPos(currentVector.endPoint());
			parent.setCenterX(currentVector.getX());
			parent.setCenterY(currentVector.getY());
		}
	}
	
	@Override
	public void handleMessage(ComponentType type, String message){
		// TODO 
	}

	@Override
	public void init(GameContainer gc){
		currentVector = new Vector(parent.getX(), parent.getY(), 0, 0);
		accelTick = new Vector(parent.getX(), parent.getY(), 0, accel);
	}

	@Override
	public void cleanUp(){}
	
	/*
	 * Functions start.
	 */
	public void addVector(Vector other){
		this.currentVector = this.currentVector.add(other);
	}
	
	public void addAccelInDirection(float direction){
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
