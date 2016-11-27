/* 
Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
APCS1 pd1
HW30 -- Ye Olde Role Playing Game, Expanded
2016-11-20
*/ 

public abstract class Monster extends Character {
    
    //Initializes the attributes of the monster by using a constructor  
    public Monster(int setHP, int setStrength, int setDefense, double setAttackRating, double setEXP) {
	HP = setHP;
	strength = setStrength;
	defense = setDefense;
	attackRating = setAttackRating;
	EXP = setEXP;

    }

     public double getEXP() {
	return EXP;
    }
   
}

	
    
