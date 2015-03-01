package dearden.voidspace.systems;

import dearden.voidspace.entities.*;
import static dearden.voidspace.entities.components.ComponentType.*;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SystemRender {

	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;
	
	// Lighting Stuff.
	private int hPass; // These need to be textures.
	private int vPass; // These need to be textures.
	private int bloomFBO; // FrameBufferObject that applies the Gaussian blur.
	
	// Particle Stuff.
	//public static ParticleSystem particleSystem;
	
	public void init(){
		camera = new OrthographicCamera();
		camera.setToOrtho(true);
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(camera.combined);
		//particleSystem = new ParticleSystem("res/effects/puff.png", 1000);
		//particleSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}
	
	public void update(float delta, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(ANIMATION)){
				entityDB.get(x).updateComponentType(delta, ANIMATION);
			}
			
			//if(entityDB.get(x).hasComponent(PARTICLE)){
				//entityDB.get(x).updateComponentType(gc, delta, PARTICLE);
				//particleSystem.update(delta);
			//}
		}
	}
	
	public void render(List<Entity> entityDB){
		spriteBatch.begin();
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(RENDER) ||
			   entityDB.get(x).hasComponent(ANIMATION)){
				entityDB.get(x).renderComponentType(spriteBatch, RENDER);
				entityDB.get(x).renderComponentType(spriteBatch, ANIMATION);
			}
		spriteBatch.end();
		
			if(entityDB.get(x).hasComponent(LIGHTING)){
				// Do all the lighting code.
			}
		}
		//particleSystem.render();
	}
}
