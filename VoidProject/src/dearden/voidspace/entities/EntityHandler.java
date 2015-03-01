package dearden.voidspace.entities;

import dearden.voidspace.entities.components.ComponentAnimation;
import dearden.voidspace.entities.components.ComponentControl;
import static dearden.voidspace.entities.components.ComponentHandler.componentDB;
import dearden.voidspace.entities.components.ComponentMotion;
import dearden.voidspace.entities.components.ComponentParticle;
import dearden.voidspace.entities.components.ComponentRender;
import dearden.voidspace.entities.components.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class EntityHandler {

	public List<Entity> entityDB;
	private Entity entityBuilder;
	
	public EntityHandler(){
		entityDB = new ArrayList<Entity>();
		
		entityBuilder = new Entity(100, 100, 25, 25);
		//entityBuilder.addComponent(new ComponentRender("res/ship.png"));
		entityBuilder.addComponent(new ComponentAnimation(2 ,1 ,"res/ship_sheet.png", 44, 32));
		entityBuilder.addComponent(new ComponentMotion(10f, 0.3f));
		entityBuilder.addComponent(new ComponentControl((ComponentMotion)entityBuilder.getComponent(ComponentType.MOTION, ComponentMotion.class)));
		//entityBuilder.addComponent(componentDB.get(1000));
		//entityBuilder.addComponent(componentDB.get(500));
		
		for(int x = 0; x < entityBuilder.getBaseComponents().size(); x++){
			entityBuilder.getBaseComponents().get(x).init();
		}
		
		entityDB.add(entityBuilder);
	}
}
