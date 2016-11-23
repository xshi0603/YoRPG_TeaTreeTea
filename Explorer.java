public class Explorer extends Character {
    public Explorer (String inputName) {
	super(100, 46, 36, 1.0);
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
