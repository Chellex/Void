package dearden.voidspace.entities.components;

import static dearden.voidspace.entities.components.ComponentType.*;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class ComponentSound extends Component{

	private Sound soundEffect;
	
	public ComponentSound(String fileDir){
		this.type = SOUND;
		try{
			soundEffect = new Sound(fileDir);
		}catch(SlickException e){
			System.err.println("The sound effect " + name + " didn't load properly!");
		}
	}
	
	/*
	 * Functions start.
	 */
	public void play(){
		soundEffect.play();
	}
	public void playPitchVolume(float pitch, float volume){
		soundEffect.play(pitch, volume);
	}
	public void loop(){
		soundEffect.loop();
	}
	public void loopPitchVolume(float pitch, float volume){
		soundEffect.loop(pitch, volume);
	}
	
	/*
	 * Required Functions start.
	 */
	@Override
	public void handleMessage(ComponentType type, String message){
		// TODO
	}
	
	@Override
	public void cleanUp(){
		
	}
}
