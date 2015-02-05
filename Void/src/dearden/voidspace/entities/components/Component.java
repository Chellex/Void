package dearden.voidspace.entities.components;

public abstract class Component {

	protected String name;
	protected ComponentType type;
	
	public String getName(){
		return name;
	}
	
	/*
	 * Functions start.
	 */
	public void init(){
		
	}
	
	public void update(){
		
	}
	
	public abstract void handleMessage(String message);
	
	public void cleanUp(){
		
	}
	
	/*
	 * GET Functions start.
	 */
	public ComponentType getType(){
		return type;
	}
}
