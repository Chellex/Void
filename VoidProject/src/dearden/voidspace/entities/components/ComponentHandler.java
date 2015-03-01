package dearden.voidspace.entities.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentHandler {

	public static Map<Integer, Component> componentDB;
	
	public void init(){
		componentDB = new HashMap<Integer, Component>();
		
		//List of Sound Effects
		//componentDB.put(500, new ComponentSound("res/sounds/laser1.wav"));
		
		//List of Particle Effects.
		//componentDB.put(1000, new ComponentParticle("res/effects/pEffect_OnFire.xml").setId(1000).setName("pEffect_OnFire"));
		//componentDB.put(1001, new ComponentParticle("res/effects/pEffect_SmallExplosion.xml").setId(1001).setName("pEffect_SmallExplosion"));
	}
}
