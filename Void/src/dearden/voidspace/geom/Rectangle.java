package dearden.voidspace.geom;

public class Rectangle extends Point{

	private float height;
	private float width;
	
	public Rectangle(float x, float y, float height, float width){
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	/*
	 * Functions start.
	 */
	public void setHeight(float height){
		this.height = height;
	}
	
	public void setWidth(float width){
		this.width = width;
	}
	
	public boolean contains(Point point){
		if(point.getX() >= this.x && point.getX() <= this.x + this.width &&
		   point.getY() >= this.y && point.getY() <= this.y + this.height){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean axisAlignedCollision(Rectangle other){
		if (this.x < other.x + other.width &&
			this.x + this.width > other.x &&
			this.y < other.y + other.height &&
			this.height + this.y > other.y){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	public boolean overlaps(Circle circle){
		
	}
	
	public boolean overlaps(Triangle tri){
		
	}*/
	
	/*
	 * GET Functions start.
	 */
	public float getHeight(){
		return height;
	}
	
	public float getWidth(){
		return width;
	}
}
