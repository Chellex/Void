package dearden.voidspace.entities.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ComponentRender extends Component{

	private Image sprite;
	private boolean visible;
	
	public ComponentRender(String sprite_dir)
	throws SlickException{
		type = ComponentType.RENDER;
		sprite = new Image(sprite_dir);
		visible = true;
	}
	
	/*
	 * Functions start.
	 */
	@Override
	public void render(GameContainer gc, Graphics g){
		if(visible == true){
			sprite.draw(parent.getX(), parent.getY());
		}
	}

	@Override
	public void handleMessage(ComponentType type, String message) {
		// TODO
	}
	
	/*
	 * SET Functions start.
	 */
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	@Override
	public void cleanUp() {
		try{
			sprite.destroy();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
}
