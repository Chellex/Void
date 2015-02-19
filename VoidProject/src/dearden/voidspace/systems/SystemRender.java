package dearden.voidspace.systems;

import dearden.voidspace.entities.*;
import static dearden.voidspace.entities.components.ComponentType.*;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.particles.ParticleSystem;

public class SystemRender {

	// Lighting Stuff.
	private int hPass; // These need to be textures.
	private int vPass; // These need to be textures.
	private int bloomFBO; // FrameBufferObject that applies the Gaussian blur.
	
	// Particle Stuff.
	public static ParticleSystem particleSystem;
	
	public void init(){
		particleSystem = new ParticleSystem("res/effects/puff.png", 1000);
		particleSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}
	
	public void update(GameContainer gc, int delta, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(ANIMATION)){
				entityDB.get(x).updateComponentType(gc, delta, ANIMATION);
			}
			
			if(entityDB.get(x).hasComponent(PARTICLE)){
				entityDB.get(x).updateComponentType(gc, delta, PARTICLE);
				particleSystem.update(delta);
			}
		}
	}
	
	public void render(GameContainer gc, Graphics g, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(RENDER) ||
			   entityDB.get(x).hasComponent(ANIMATION)){
				entityDB.get(x).renderComponentType(gc, g, RENDER);
				entityDB.get(x).renderComponentType(gc, g, ANIMATION);
			}
			
			if(entityDB.get(x).hasComponent(LIGHTING)){
				// Do all the lighting code.
			}
		}
		particleSystem.render();
	}
}
