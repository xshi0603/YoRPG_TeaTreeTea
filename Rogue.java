public class Rogue extends Character {
    public Rogue(String inputName) {
	super(100, 40, 45, 1.0);
	name = inputName;
    }
    
    public void specialize() {
	defense -= 14;
	strength += 28;
    }

    public void normalize() {
	strength = ogStrength;
	defense = ogDefense;
    }
}
