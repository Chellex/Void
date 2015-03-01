package dearden.voidspace.ships.addons;

public enum ArmorType {
	
	// First Digit is Beam Damage Resist %
	// Second Digit is Void Damage Resist %
	// Third Digit is Physical Damage Resist %
	// Fourth Digit is Explosive Damage Resist %
	NANO		(new float[]{0.70f,0,0,0}),
	HARMONIC	(new float[]{0.88f,0,0.88f,0}),
	TRITONIC	(new float[]{0.92f,0.92f,0,0.92f}),
	QUADRATIC	(new float[]{0.95f,0.95f,0.95f,0.95f}),
	ENERGY		(new float[]{0.9f,0.9f,0,0}),
	PLASMA		(new float[]{0.9f,0,0.9f,0.9f});
	
	private float[] resists;
	
	private ArmorType(float[] resists){
		this.resists = resists;
	}
	
	public float[] getResists(){
		return this.resists;
	}
}
