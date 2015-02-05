package dearden.voidspace.entities;

import dearden.voidspace.entities.components.Component;
import dearden.voidspace.entities.components.ComponentType;
import dearden.voidspace.geom.Rectangle;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity extends Rectangle {

	protected List<Component> baseComponents;
	
	public Entity(float x, float y, float height, float width){
		super(x, y, height, width);
		baseComponents = new ArrayList<Component>();
	}
	
	/*
	 * Functions start.
	 */
	public void init(){
		
	}
	
	public void addComponent(Component component){
		baseComponents.add(component);
	}
	
	public void removeComponent(String name){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getName() == name){
				baseComponents.remove(x);
			}
		}
	}
	
	public void updateComponents(){
		for(int x = 0; x < baseComponents.size(); x++){
			baseComponents.get(x).update();
		}
	}
	
	public void updateComponentType(ComponentType type){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getType() == type){
				baseComponents.get(x).update();
			}
		}
	}
	
	public abstract void handleMessage(String message);
	
}
