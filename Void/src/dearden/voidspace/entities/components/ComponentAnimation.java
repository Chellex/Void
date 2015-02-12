package dearden.voidspace.entities.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dearden.voidspace.systems.Game;

public class ComponentAnimation extends Component {

	private int frames;
	private int currentFrame = 0;
	private int speed;				//Number of Game.TICK before image change.
	private int deltaStore;
	private Image[] animation;
	
	public ComponentAnimation(int frames, int speed, String spriteSheetDir, int height, int width)
	throws SlickException{
		type = ComponentType.ANIMATION;
		
		this.speed = speed;
		this.frames = frames;
		
		animation = new Image[frames];
		for(int x = 0; x < frames; x++){
			animation[x] = new Image(spriteSheetDir).getSubImage(x * width, 0, width, height);
		}
	}
	
	/*
	 * Functions start.
	 */
	@Override
	public void update(GameContainer gc, int delta){
		deltaStore += delta;
		
		if(deltaStore > Game.TICK * speed){
			deltaStore = 0;
			
			if(currentFrame == frames - 1){
				currentFrame = 0;
			}else{
				currentFrame += 1;
			}
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g){
		animation[currentFrame].draw(parent.getX(), parent.getY());
	}

	@Override
	public void handleMessage(ComponentType type, String message) {
		if(type == ComponentType.CONTROL){
			animation[currentFrame].setRotation(Float.parseFloat(message) + 90);
		}
	}

	public void cleanUp(){
		try{
			for(int x = 0; x < animation.length; x++){
				animation[x].destroy();
			}
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
}
