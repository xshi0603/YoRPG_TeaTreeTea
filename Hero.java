public abstract class Hero extends Character {
    //protected double EXP;
    //protected int LVL;
    protected int counter; 
    
    public Hero (int setHP, int setStrength, int setDefense, double setAttackRating, double setEXP, int setLVL) {
        HP = setHP;
	strength = setStrength;
	defense = setDefense;
	attackRating = setAttackRating;
	EXP = setEXP;
	LVL = setLVL;

	
    }

   
    public double getLVL() {
	return LVL;
    }

    public void setLVL() {
	counter = LVL;
	LVL = (int) (EXP / 100);
    }

    public boolean lvlUP() {
	return (counter < LVL );
    }

    public void gainEXP(double MonsterEXP) {
	EXP += MonsterEXP;
    }

    public void gainLVL() {
	if (counter < LVL) {
	    strength += (int) ( (Math.random() * 5) + 10 );
	    defense += (int) ( (Math.random() * 5) + 5 );
	}
	
    }
	
}
