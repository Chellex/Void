package dearden.voidspace.systems;

import dearden.voidspace.entities.*;
import dearden.voidspace.entities.components.ComponentType;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class SystemRender {

	public SystemRender(){
		
	}
	
	public void update(GameContainer gc, int delta, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(ComponentType.ANIMATION)){
				entityDB.get(x).updateComponentType(gc, delta, ComponentType.ANIMATION);
			}
		}
	}
	
	public void render(GameContainer gc, Graphics g, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(ComponentType.RENDER) ||
			   entityDB.get(x).hasComponent(ComponentType.ANIMATION)){
				entityDB.get(x).renderComponentType(gc, g, ComponentType.RENDER);
				entityDB.get(x).renderComponentType(gc, g, ComponentType.ANIMATION);
			}
		}
	}
}
