package dearden.voidspace.entities.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;

import dearden.voidspace.systems.Game;

public class ComponentAnimation extends Component {

	private int frames;
	private int currentFrame = 0;
	private int speed;				//Number of Game.TICK before image change.
	private int deltaStore;
	private Sprite[] animation;
	
	public ComponentAnimation(int frames, int speed, String spriteSheetDir, int height, int width){
		type = ComponentType.ANIMATION;
		
		this.speed = speed;
		this.frames = frames;
		
		animation = new Sprite[frames];
		Texture tex = new Texture(spriteSheetDir);
		for(int x = 0; x < frames; x++){
			//animation[x] = new Image(spriteSheetDir).getSubImage(x * width, 0, width, height);
			
			animation[x] = new Sprite(new TextureRegion(tex, x * width, 0, width, height));
		}
	}
	
	/*
	 * Functions start.
	 */
	@Override
	public void update(float delta){
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
	public void render(SpriteBatch batch){
		//animation[currentFrame].draw(parent.getX(), parent.getY());
		animation[currentFrame].setPosition(parent.getX(), parent.getY());
		animation[currentFrame].draw(batch);
	}

	@Override
	public void handleMessage(ComponentType type, String message) {
		if(type == ComponentType.CONTROL){
			animation[currentFrame].setRotation(Float.parseFloat(message) + 270);
		}
	}

	public void cleanUp(){
		
	}
}
