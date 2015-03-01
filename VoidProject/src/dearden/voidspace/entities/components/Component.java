package dearden.voidspace.entities.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dearden.voidspace.entities.Entity;

public abstract class Component {

	public int id;
	
	protected Entity parent;
	protected String name;
	protected ComponentType type;
	
	/*
	 * Functions start.
	 */
	public void init(){}
	
	public void update(float delta){}
	
	public void render(SpriteBatch batch){}
	
	public abstract void handleMessage(ComponentType type, String message);
	
	public abstract void cleanUp();
	
	/*
	 * SET Functions start.
	 */
	public void setParent(Entity parent){
		this.parent = parent;
	}
	public Component setName(String name){
		this.name = name;
		return this;
	}
	public Component setId(int id){
		this.id = id;
		return this;
	}
	
	/*
	 * GET Functions start.
	 */
	public ComponentType getType(){
		return type;
	}
	public String getName(){
		return name;
	}
}
