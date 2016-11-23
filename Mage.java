/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Mage extends Character {

    //Initializes the attributes of the monster by using an overloaded constructor that will take in a string input for the name
    public Mage (String InputName) {
        super(450, 120, 40, 0.9);
	name = InputName;
    }
}
