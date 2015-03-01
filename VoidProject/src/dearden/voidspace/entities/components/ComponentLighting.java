package dearden.voidspace.entities.components;

/*
 * Class Explanation - ComponentLighting
 * =============================================================
 * I want to create a glowing effect over entities or effects
 * to add a little more pizaz to the graphics maybe something
 * like what a laser tag arena looks like to a small child.
 * 
 * I am using OpenGL 2.0 Shaders to do this. The end-user will
 * be notified that this program requires OpenGL 2.0 or above
 * for shader functionality. Alternatively, an end-user with
 * practically ancient hardware can turn the lighting effects
 * off so he/she can still play the game.
 */
public class ComponentLighting extends Component {
	/*
	 * Fields start.
	 */
	private float[] ambient;
	private float[] diffuse;
	private float[] specular;
	
	public void ComponentLighting(){
		
	}
	
	/*
	 * Required Functions start.
	 */
	@Override
	public void init(){
		
	}
	
	@Override
	public void handleMessage(ComponentType type, String message) {
		// TODO 
	}

	@Override
	public void cleanUp() {
		// TODO 
	}
	
	/*
	 * Functions start.
	 */
	
	/*
	 * GET Functions start.
	 */
}
