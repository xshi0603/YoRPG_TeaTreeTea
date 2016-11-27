/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public abstract class Character {

    protected String name;
    protected int HP;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected double EXP;
    protected int LVL;

    
    /* public Character (int setHP, int setStrength, int setDefense, double setAttackRating, double setEXP ) {
        HP = setHP;
	strength = setStrength;
	defense = setDefense;
	attackRating = setAttackRating;
	EXP = setEXP;
    }
    */ 

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

    public double getEXP() {
	return EXP;
    }
    
    public double getAttackRating() {
	return attackRating;
    }

    public int lowerHP (int points) {
 	HP -= points;
	return HP;
    }

    public double getLVL() {
	return LVL;
    }
    
    public int attack (Character victim) {
	int damage = (int)( (strength * attackRating) - victim.defense );
	
	if (damage < 0) {
	    damage = 0;
	}
	
	victim.lowerHP(damage);
	return damage;

    }

   

    public abstract void specialize();
    public abstract void normalize();

    /* public abstract void getLVL();
    public abstract void setLVL(); 
    public abstract boolean lvlUP();
    public abstract void gainLVL();
    //public abstract void gainEXP(); 
    
    //public abstract void getEXP(); 
    */
    
    public abstract String about(Character player);  
    public String toString() {
	return this.getClass().getName();
    }

}

