package dearden.voidspace.geom;

public class Circle extends Point {

	private float radius;
	
	public Circle(float x, float y, float radius){
		super(x, y);
		this.radius = radius;
	}
	
	/*
	 * Functions start.
	 */
	public boolean contains(Point point){
		if(this.distance(point) <= radius){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	public boolean overlaps(Rectangle rect){
		
	}*/
	
	public boolean overlaps(Circle other){
		if(this.distance(other) >= this.radius + other.radius){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	public boolean overlaps(Triangle tri){
		
	}*/
}
