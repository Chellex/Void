package dearden.voidspace.entities.components;

import dearden.voidspace.entities.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class Component {

	public int id;
	
	protected Entity parent;
	protected String name;
	protected ComponentType type;
	
	/*
	 * Functions start.
	 */
	public void init(GameContainer gc){}
	
	public void update(GameContainer gc, int delta){}
	
	public void render(GameContainer gc, Graphics g){}
	
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
