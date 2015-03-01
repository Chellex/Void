package dearden.voidspace.systems;

import java.util.List;

import dearden.voidspace.entities.Entity;
import dearden.voidspace.entities.components.ComponentType;

public class SystemMotion {

	public void update(float delta, List<Entity> entityDB){
		for(int x = 0; x < entityDB.size(); x++){
			if(entityDB.get(x).hasComponent(ComponentType.MOTION)){
				entityDB.get(x).updateComponentType(delta, ComponentType.MOTION);
			}
		}
	}
}
