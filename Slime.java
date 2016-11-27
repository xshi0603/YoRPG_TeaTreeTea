/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Slime extends Monster {

    //Initializes the attributes of the monster by using a default constructor that will call the constructor in class Monster 
    public Slime () {
        super(150, 60, 10, 3.0, ( (Math.random() * 50) + 100 ) );
	name = "Monster Slime";
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
	    "\nExperience: " + player.getEXP() ;
	return retString;
    }
    
}
