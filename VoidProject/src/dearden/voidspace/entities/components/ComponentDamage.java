package dearden.voidspace.entities.components;

import dearden.voidspace.ships.addons.DamageType;

public class ComponentDamage extends Component {

	public DamageType type;
	public float damage;
	
	@Override
	public void handleMessage(ComponentType type, String message) {
		// TODO 
	}

	@Override
	public void cleanUp() {
		// TODO 
	}
}
