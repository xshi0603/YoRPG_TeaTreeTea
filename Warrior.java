/* 
Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
APCS1 pd1
HW31 -- Ye Olde Role Playing Game, Improved
2016-11-17
*/ 

public class Warrior extends Character {
     //Initializes the attributes of the monster by using an overloaded constructor that will take in a string input for the name
    public Warrior (String InputName) {
        super(100, 60, 40, 1.0);
	name = InputName;
    }

    public void specialize() {
	defense -= 10;
	strength += 20;
    }

    public void normalize() {
	strength = ogStrength;
	defense = ogDefense;
    }
	

}

