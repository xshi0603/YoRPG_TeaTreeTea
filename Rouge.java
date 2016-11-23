/* 
   Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20
*/ 

public class Rouge extends Character {

    //Initializes the attributes of the monster by using an overloaded constructor that will take in a string input for the name
    public Rouge (String InputName) {
        super(400, 75, 15, 1.75);
	name = InputName;
    }
}
