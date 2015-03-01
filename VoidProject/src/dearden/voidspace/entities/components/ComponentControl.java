package dearden.voidspace.entities.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static dearden.voidspace.entities.components.ComponentType.*;
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
		// Temp. I will pass in an int array from the options screen.
		keys = new int[12];
		keys[0] = Input.Keys.W;
		keys[1] = Input.Keys.S;
		keys[2] = Input.Keys.A;
		keys[3] = Input.Keys.D;
		keys[4] = Input.Keys.NUM_1;
		keys[5] = Input.Keys.NUM_2;
		keys[6] = Input.Keys.NUM_3;
		keys[7] = Input.Buttons.LEFT;
		keys[8] = Input.Buttons.RIGHT;
		keys[9] = Input.Keys.Q;
		keys[10] = Input.Keys.E;
		keys[11] = Input.Keys.SPACE;
	}
	
	@Override
	public void handleMessage(ComponentType type, String message){
		
	}
	
	@Override
	public void init(){
		type = ComponentType.CONTROL;
		input = Gdx.input;
	}

	@Override
	public void update(float delta){
		
		parent.sendMessage(type, Math.toDegrees(
		Math.atan2(input.getY(0) - parent.getCenterY(), input.getX(0) - parent.getCenterX()))+ "");
		
		if(input.isButtonPressed(keys[7])){
			if(parent.hasComponent(SOUND)){
				parent.getComponent(SOUND, ComponentSound.class).play();
			}
		}
		
		// If control scheme DIRECTIONAL is chosen in options.
		if(input.isKeyPressed(keys[0])){
			motion.addAccelInDirection(270, delta);
		}
		if(input.isKeyPressed(keys[1])){
			motion.addAccelInDirection(90, delta);
		}
		if(input.isKeyPressed(keys[2])){
			motion.addAccelInDirection(180, delta);
		}
		if(input.isKeyPressed(keys[3])){
			motion.addAccelInDirection(0, delta);
		}
	}

	@Override
	public void cleanUp(){
		
	}
}
