package dearden.voidspace.entities.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import dearden.voidspace.geom.Vector;

public class ComponentControl extends Component{

	private ComponentMotion motion;
	private Input input;
	private boolean enabled;
	private int[] keys;
	/*
	 * ------------------------------------------------------------
	 * ArrayIndex                        / Defaults
	 * ------------------------------------------------------------
	 * 0 - UP                            / W
	 * 1 - DOWN                          / S
	 * 2 - LEFT                          / A
	 * 3 - RIGHT                         / D
	 * ------------------------------------------------------------
	 * 4 - Toggle Primary Weapon         / 1
	 * 5 - Toggle Secondary Weapon       / 2
	 * 6 - Toggle Thrusters              / 3
	 * ------------------------------------------------------------
	 * 7 - Fire Primary Weapon           / Left Mouse Button
	 * 8 - Fire Primary Weapon           / Right Mouse Button
	 * ------------------------------------------------------------
	 * 9 - Utility Item 1                / Q
	 * 10 - Utility Item 2               / E
	 * ------------------------------------------------------------
	 * 11 - BRAKE                        / Space
	 */
	
	public ComponentControl(ComponentMotion motion){
		this.motion = motion;
		// Temp
		keys = new int[12];
		keys[0] = Input.KEY_W;
		keys[1] = Input.KEY_S;
		keys[2] = Input.KEY_A;
		keys[3] = Input.KEY_D;
		keys[4] = Input.KEY_1;
		keys[5] = Input.KEY_2;
		keys[6] = Input.KEY_3;
		keys[7] = Input.MOUSE_LEFT_BUTTON;
		keys[8] = Input.MOUSE_RIGHT_BUTTON;
		keys[9] = Input.KEY_Q;
		keys[10] = Input.KEY_E;
		keys[11] = Input.KEY_SPACE;
	}
	
	@Override
	public void handleMessage(ComponentType type, String message){
		
	}
	
	@Override
	public void init(GameContainer gc){
		type = ComponentType.CONTROL;
		input = gc.getInput();
	}

	@Override
	public void update(GameContainer gc, int delta){
		
		parent.sendMessage(type, Math.toDegrees(
		Math.atan2(input.getMouseY() - parent.getCenterY(), input.getMouseX() - parent.getCenterX()))+"");
		
		//motion.getCurrentVector().setPos(input.getMouseX(), input.getMouseY());
		
		if(input.isKeyDown(keys[0])){
			motion.addAccelInDirection(270);
		}
		if(input.isKeyDown(keys[1])){
			motion.addAccelInDirection(90);
		}
		if(input.isKeyDown(keys[2])){
			motion.addAccelInDirection(180);
		}
		if(input.isKeyDown(keys[3])){
			motion.addAccelInDirection(0);
		}
		if(input.isKeyDown(keys[11])){
			motion.addVector(new Vector(parent.getCenterX(),
										parent.getCenterY(),
										motion.getCurrentVector().getDirection() + 180, 
										motion.getCurrentVector().getMagnitude()/2));
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g){
		
	}

	@Override
	public void cleanUp(){
		
	}
}
