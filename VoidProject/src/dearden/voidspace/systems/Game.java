package dearden.voidspace.systems;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dearden.voidspace.entities.EntityHandler;
import dearden.voidspace.entities.components.ComponentHandler;

public class Game extends ApplicationAdapter {
	public static float TICK = 16.66f;
	private float delta;
	
	ComponentHandler componentHandler;
	EntityHandler entityHandler;
	SystemRender systemRender;
	SystemMotion systemMotion;
	SystemControl systemControl;
	
	@Override
	public void create(){
		Gdx.graphics.setDisplayMode(800,600, true);
		
		componentHandler = new ComponentHandler();
		componentHandler.init();
		entityHandler = new EntityHandler();
		systemRender = new SystemRender();
		systemRender.init();
		systemMotion = new SystemMotion();
		systemControl = new SystemControl();
	}

	public void update(){
		delta = Gdx.graphics.getDeltaTime();
		
		systemControl.update(delta, entityHandler.entityDB);
		systemMotion.update(delta, entityHandler.entityDB);
		systemRender.update(delta, entityHandler.entityDB);
	}
	
	@Override
	public void render(){
		update();									// Update movement/math before rendering.
		Gdx.gl.glClearColor(0, 0, 0, 1);			// Set the clear color to black.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Clear the screen.
		
		systemRender.render(entityHandler.entityDB);
	}
}
