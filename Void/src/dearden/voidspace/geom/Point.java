package dearden.voidspace.geom;

public class Point {

	protected float x;
	protected float y;
	
	public Point(float new_x, float new_y){
		this.x = new_x;
		this.y = new_y;
	}
	
	/*
	 * Functions start.
	 */
	public void setPos(float new_x, float new_y){
		this.x = new_x;
		this.y = new_y;
	}
	
	public void setPos(Point other){
		this.x = other.x;
		this.y = other.y;
	}
	
	public Point midpoint(Point other){
		return new Point((this.x + other.x) / 2, (this.y + other.y) / 2);
	}
	
	public float distance(Point other){
		return (float) Math.abs(Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2)));
	}
	
	public void translate(float add_x, float add_y){
		this.x += add_x;
		this.y += add_y;
	}
	
	/*
	 * GET Functions start.
	 */
	public float[] getPos(){
		return new float[]{x,y};
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
}
