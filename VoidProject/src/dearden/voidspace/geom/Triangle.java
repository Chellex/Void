package dearden.voidspace.geom;

public class Triangle extends Point{

	private float base;
	private float height;
	
	private Vector A;
	private Vector B;
	private Vector C;
	
	public Triangle(float x, float y, float base, float height){
		super(x, y);
		this.base = base;
		this.height = height;
	}
	
	/*
	 * Functions start.
	 */
	
	/*
	public boolean contains(Point point){
		
	}
	
	public boolean overlaps(Rectangle rect){
		
	}
	
	public boolean overlaps(Circle circle){
		
	}
	
	public boolean overlaps(Triangle other){
		
	}*/
}
