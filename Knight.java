public class Knight extends Character {
    public Knight(String inputName) {
	super (100, 55, 50, 1.12);
	name = inputName;
    }
    
    public void specialize() {
	defense -= 15;
	strength += 30;
    }

    public void normalize() {
	strength = ogStrength;
	defense = ogDefense;
    }
}
