package dearden.voidspace.systems;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import dearden.voidspace.entities.Entity;
import dearden.voidspace.entities.components.ComponentType;

public class SystemSound {

	public void update(GameContainer gc, int delta, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(ComponentType.SOUND)){
				entityDB.get(x).updateComponentType(gc, delta, ComponentType.SOUND);
			}
		}
	}
}
