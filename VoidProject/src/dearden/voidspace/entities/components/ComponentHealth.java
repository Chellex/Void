package dearden.voidspace.entities.components;

import java.util.ArrayList;
import java.util.List;

public class ComponentHealth extends Component {

	private int maxHealth;
	private float currentHealth;
	private float incomingDamage;
	
	@Override
	public void init(){
		
	}
	
	public boolean applyDamage(float damage){
		currentHealth -= damage;
		
		if(currentHealth <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public void handleMessage(ComponentType type, String message) {
		// TODO 
	}

	@Override
	public void cleanUp() {
		// TODO 
	}
}
