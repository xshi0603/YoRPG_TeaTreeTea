/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Explorer extends Hero {

     //Initializes the attributes of Hero Class by using an overloaded constructor that will take in a string input for the name
    public Explorer (String InputName) {
        super(600, 80, 50, 1.1, 100.0, 1);
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
	    "\nAttack Rating: " + player.getAttackRating() +
	    "\nLevel: " + player.getLVL() +
	    "\nExperience: " + player.getEXP() ;
	return retString;
    }
    
}
