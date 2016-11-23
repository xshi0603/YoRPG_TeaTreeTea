/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Warrior extends Character {

    //Initializes the attributes of the monster by using an overloaded constructor that will take in a string input for the name
    public Warrior (String InputName) {
        super(500, 100, 50, 1.25);
	name = InputName;
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
    
    public String about(Character player) {
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


