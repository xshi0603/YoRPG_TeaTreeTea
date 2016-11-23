/* 
Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
APCS1 pd1
HW31 -- Ye Olde Role Playing Game, Improved
2016-11-17
*/ 

public class Monster extends Character {
    //Initializes the attributes of the monster by using a constructor  
    public Monster() {
	super(150, (int) (Math.random() * 45 + 20), 20, 1.0);
    }

    public void specialize() {
	defense -= 13;
	strength += 26;
    }

    public void normalize() {
	strength = ogStrength;
	defense = ogDefense;
    }
}

	
    
