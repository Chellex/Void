package dearden.voidspace.entities.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ComponentRender extends Component{

	private Sprite sprite;
	private boolean visible;
	
	public ComponentRender(String sprite_dir){
		type = ComponentType.RENDER;
		Texture tex = new Texture(sprite_dir);
		sprite = new Sprite(tex);
		visible = true;
	}
	
	/*
	 * Functions start.
	 */
	@Override
	public void render(SpriteBatch batch){
		if(visible == true){
			sprite.draw(batch);
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
		
	}
}
