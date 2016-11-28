/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Paladin extends Monster {

    //Initializes the attributes of the monster by using a default constructor that calls the constructor in Monster 
    public Paladin () {
        super(300, 15, 50, 1.5, 1000);
	name = "Monster Paladin";
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
	    "Monster: " + player +
	    "\nHP: " + player.getHP() +
	    "\nStrength: " + player.getStrength() +
	    "\nDefense: " + player.getDefense() +
	    "\nAttack Rating: " + player.getAttackRating() +
	    "\nExperience: " + player.getEXP() ;
	return retString;
    }
    
}
