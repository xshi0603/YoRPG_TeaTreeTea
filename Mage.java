public class Mage extends Character {
    public Mage (String inputName) {
	super (100, 55, 40, 1.2);
	name = inputName;

    }

    public void specialize() {
	defense -= 12;
	strength += 24;
    }

    public void normalize() {
	strength = ogStrength;
	defense = ogDefense;
    }
    
}


