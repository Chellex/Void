package dearden.voidspace.entities.components;

import static dearden.voidspace.ships.addons.DamageType.*;
import static dearden.voidspace.ships.addons.ArmorType.*;
import dearden.voidspace.ships.addons.ArmorType;

public class ComponentArmor extends Component {

	public ArmorType type;
	private float incomingDamage;
	
	public float reduceIncomingDamage(ComponentDamage damage){
		switch(damage.type){
			case BEAM:
				incomingDamage = damage.damage * type.getResists()[BEAM.ordinal()];
				break;
				
			case VOID:
				incomingDamage = damage.damage * type.getResists()[VOID.ordinal()];
				break;
				
			case PHYSICAL:
				incomingDamage = damage.damage * type.getResists()[PHYSICAL.ordinal()];
				break;
				
			case EXPLOSIVE:
				incomingDamage = damage.damage * type.getResists()[EXPLOSIVE.ordinal()];
				break;
		}
		
		return incomingDamage;
	}
	
	public void setType(ArmorType type){
		this.type = type;
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
