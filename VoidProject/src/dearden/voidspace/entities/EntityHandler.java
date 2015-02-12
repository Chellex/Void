package dearden.voidspace.entities;

import dearden.voidspace.entities.components.ComponentAnimation;
import dearden.voidspace.entities.components.ComponentControl;
import dearden.voidspace.entities.components.ComponentMotion;
import dearden.voidspace.entities.components.ComponentRender;
import dearden.voidspace.entities.components.ComponentType;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class EntityHandler {

	public List<Entity> entityDB;
	private Entity entityBuilder;
	
	public EntityHandler(GameContainer gc)
	throws SlickException{
		entityDB = new ArrayList<Entity>();
		
		entityBuilder = new Entity(100, 100, 25, 25);
		//entityBuilder.addComponent(new ComponentRender("res/ship.png"));
		entityBuilder.addComponent(new ComponentAnimation(2 ,1 ,"res/ship_sheet.png", 44, 32));
		entityBuilder.addComponent(new ComponentMotion(50f, 0.0300f));
		entityBuilder.addComponent(new ComponentControl((ComponentMotion)entityBuilder.getComponent(ComponentType.MOTION)));
		
		for(int x = 0; x < entityBuilder.getBaseComponents().size(); x++){
			entityBuilder.getBaseComponents().get(x).init(gc);
		}
		
		entityDB.add(entityBuilder);
	}
}
