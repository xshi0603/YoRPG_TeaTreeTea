/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Character {

    protected String name;
    protected int HP;
    protected int strength;
    protected int defense;
    protected double attackRating;

    public Character (int setHP, int setStrength, int setDefense, double setAttackRating ) {
        HP = setHP;
	strength = setStrength;
	defense = setDefense;
	attackRating = setAttackRating;
    }

    int i = 0;
    public Boolean isAlive() {
	return (HP > 0);
    }
    public int getHP() {
	return HP;
    }

    public int getStrength() {
	return strength;
    }

    public int getDefense() {
	return defense;
    }

    public String getName() {
	return name;
    }

    public double getAttackRating() {
	return attackRating;
    }

    public int lowerHP (int points) {
 	HP -= points;
	return HP;
    }

    public int attack (Character victim) {
	int damage = (int)( (strength * attackRating) - victim.defense );
	
	if (damage < 0) {
	    damage = 0;
	}
	
	victim.lowerHP(damage);
	return damage;

    }

    public void specialize () {
	defense -= 10;
	strength += 20;
	i += 1;
    }

    public void normalize() {
	defense += (10 * i);
	strength -= (20 * i);
	i = 0;
    }
    public String toString() {
	return this.getClass().getName();
    }
    
    public static String about(Character player) {
	String retString = "";
	retString +=
	    "Class: " + player +
	    "\nHP: " + player.getHP() +
	    "\nStrength: " + player.getStrength() +
	    "\nDefense: " + player.getDefense() +
	    "\nAttack Rating: " + player.getAttackRating();
	return retString;
    }
}

