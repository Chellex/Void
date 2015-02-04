package dearden.voidspace.geom;

public class Vector extends Point{

	private float direction;
	private float magnitude;
	
	public Vector(float x, float y){
		super(x, y);
	}
	
	public Vector(Point origin, Point end){
		super(origin.x, origin.y);
		magnitude = origin.distance(end);
		
		if(end.x - origin.x == 0){
			if(end.y - origin.y > 0){
				direction = 0f;
			}else{
				direction = 180f;
			}
		}else{
			if(end.y - origin.y == 0){
				if(end.x - origin.x > 0){
					direction = 90f;
				}else{
					direction = 270f;
				}
			}else{
				direction = (float) Math.toDegrees(Math.atan((end.y - origin.y / end.x - origin.x)));
			}
		}
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
		return new Vector(this.x + other.x, this.y + other.y);
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
