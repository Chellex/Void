package dearden.voidspace.entities;

import dearden.voidspace.entities.components.ComponentRender;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;

public class EntityHandler {

	public List<Entity> entityDB;
	private Entity entityBuilder;
	
	public EntityHandler()
	throws SlickException{
		entityDB = new ArrayList<Entity>();
		
		entityBuilder = new Entity(100, 100, 25, 25);
		entityBuilder.addComponent(new ComponentRender("res/ship.png"));
		entityDB.add(entityBuilder);
	}
}
