package dearden.voidspace.entities;

import dearden.voidspace.entities.components.Component;
import dearden.voidspace.entities.components.ComponentType;
import dearden.voidspace.geom.Rectangle;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity extends Rectangle {

	protected List<Component> baseComponents;
	
	public Entity(float x, float y, float height, float width){
		super(x, y, height, width);
		baseComponents = new ArrayList<Component>();
	}
	
	/*
	 * Functions start.
	 */
	public void init(){}
	
	public void addComponent(Component component){
		component.setParent(this);
		baseComponents.add(component);
	}
	
	public void removeComponent(String name){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getName() == name){
				baseComponents.get(x).cleanUp();
				baseComponents.remove(x);
			}
		}
	}
	
	public void updateComponents(float delta){
		for(int x = 0; x < baseComponents.size(); x++){
			baseComponents.get(x).update(delta);
		}
	}
	
	public void renderComponents(SpriteBatch batch){
		for(int x = 0; x < baseComponents.size(); x++){
			baseComponents.get(x).render(batch);
		}
	}
	
	public void updateComponentType(float delta, ComponentType type){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getType() == type){
				baseComponents.get(x).update(delta);
			}
		}
	}
	
	public void renderComponentType(SpriteBatch batch, ComponentType type){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getType() == type){
				baseComponents.get(x).render(batch);
			}
		}
	}
	
	public void sendMessage(ComponentType type, String message){
		for(int x = 0; x < baseComponents.size(); x++){
			baseComponents.get(x).handleMessage(type, message);
		}
	}
	
	/*
	 * GET Functions start.
	 */
	public boolean hasComponent(ComponentType type){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getType() == type){
				return true;
			}
		}
		return false;
	}
	
	public List<Component> getBaseComponents(){
		return baseComponents;
	}
	
	// Make this better Chris. I tried, now it's worse. Now it looks really janky.
	public <T extends Component> T getComponent(ComponentType type, Class<T> obj){
		for(int x = 0; x < baseComponents.size(); x++){
			if(baseComponents.get(x).getType() == type){
				return obj.cast(baseComponents.get(x));
			}
		}
		return null;
	}
}
