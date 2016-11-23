public abstract class Character {

    protected String name;
    protected int HP;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected int ogStrength;
    protected int ogDefense; 

    public Character (int setHP, int setStrength, int setDefense, double setAttackRating ) {
        HP = setHP;
	strength = setStrength;
	defense = setDefense;
	ogStrength = setStrength;
	ogDefense = setDefense;
	attackRating = setAttackRating;
    }

    public Boolean isAlive() {
	return (HP > 0);
    }

    public int getDefense() {
	return defense;
    }

    public String getName() {
	return name;
    }

    public int lowerHP (int points) {
 	HP -= points;
	return HP;
    }

    public int getHealth() {
	return HP;
    }

    public int getStrength() {
	return strength;
    }

    public double getAttackRating() {
	return attackRating;
    }

    public int attack (Character victim) {
	int damage = (int)( (strength * attackRating) - victim.defense );
	
	if (damage < 0) {
	    damage = 0;
	}
	
	victim.lowerHP(damage);
	return damage;

    }

    public abstract void specialize ();
    //defense -= 10;
    //strength += 20;
    

    public abstract void normalize(); 
    //strength = ogStrength;
    // defense = ogDefense; 
    
    
    public String toString() {
	return this.getClass().getName();
    }
    
    public static String about(Character player) {
	String retStr = "";
	retStr +=
	    "Class: " + player +
	    "\nHP: " + player.getHealth() +
	    "\nStrength: " + player.getStrength() +
	    "\nDefense: " + player.getDefense() +
	    "\nAttack Rating: " + player.getAttackRating();
	return retStr;
    }
	
       
    

}
