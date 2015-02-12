package dearden.voidspace.geom;

public class Vector extends Point{

	private float direction;
	private float magnitude;
	
	public Vector(float x, float y){
		super(x, y);
		this.direction = 0;
		this.magnitude = 0;
	}
	
	public Vector(float x, float y, float direction, float magnitude){
		super(x, y);
		this.direction = direction;
		this.magnitude = magnitude;
	}
	
	public Vector(Point origin, Point end){
		super(origin.x, origin.y);
		magnitude = origin.distance(end);
		float dx = end.x - this.x;
		float dy = end.y - this.y;
		direction = (float)Math.toDegrees(Math.atan2(dy,dx));
	}
	
	/*
	 * Functions start.
	 */
	public void setDirection(float direction){
		this.direction = direction;
	}
	
	public void setMagnitude(float magnitude){
		this.magnitude = magnitude;
	}
	
	public Vector add(Vector other){
		other.setPos(this.endPoint());
		return new Vector(this.getPos(), other.endPoint());
	}
	
	public Point endPoint(){
		float dx = (float)Math.cos(Math.toRadians(direction)) * this.magnitude;
		float dy = (float)Math.sin(Math.toRadians(direction)) * this.magnitude;
		
		return new Point(this.x + dx, this.y + dy);
	}
	
	/*
	 * GET Functions start.
	 */
	public float getDirection(){
		return direction;
	}
	
	public float getMagnitude(){
		return magnitude;
	}
}
