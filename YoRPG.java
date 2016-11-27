/* Kevin Bao , Queenie Xiang, Xing Tao Shi (Team TreeTeaTree)
   APCS1 pd1
   HW30 -- Ye Olde Role Playing Game, Expanded
   2016-11-20 */

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 10;

    //each round, a Hero and a Monster will be instantiated...
    private Character pat;   //Is it man or woman?
    private Character smaug; //Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG()
    {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame()
    {
	String s;
	String name = "";
	int job = 0;
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "\nChoose your class: \n";
	s += "\t1: Warrior\n";
	s += "\t2: Mage\n";
	s += "\t3: Rogue\n";
	s += "\t4: Explorer\n";
	s += "\t5: Knight\n";
	s += "Selection: ";
	
	System.out.print( s );

	try {
	    job = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	//instantiate the player's character
	if (job == 1) {
	    pat = new Warrior( name );
	}
	if (job == 2) {
	    pat = new Mage( name );
	}
	if (job == 3) {
	    pat = new Rogue( name );
	}
	if (job == 4) {
	    pat = new Explorer( name );
	}
	if (job == 5) {
	    pat = new Knight( name );
	}

	System.out.println("\n" + pat.about(pat) + "\n");

	


    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn()
    {
	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    double temp = Math.random();

	    if ( temp < 0.7 ) {
		if ( temp < 0.4 ) {
		    smaug = new Slime();
		}
		smaug = new Ranger();
	    }

	    else {
		smaug = new Paladin();
	    }
	    
	    System.out.print("\n" + smaug.about(smaug) + "\n");

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );
		//40 ='s
		System.out.println( "\n========================================\n" +
				    pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
		System.out.println( "\nPlayer HP: " + pat.getHP() +
				    "\nStrength: " + pat.getStrength() +
				    "\nDefense: " + pat.getDefense() +
				    "\n\nMonster HP : " + smaug.getHP() +
				    "\n========================================\n");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		double num = ((Monster)smaug).getEXP();
		((Hero)pat).gainEXP(((Monster)smaug).getEXP());
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		System.out.println( "You have gained: " + smaug.getEXP() + " EXP" );
		if (((Hero)pat).lvlUP()) {
		    ((Hero)pat).gainLVL();
		    System.out.println (
					"Congratulations, you have leveled up! You are now level " +
					pat.getLVL() );
		}
		
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args )
    {
	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...


	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;


	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );

    }//end main

}//end class YoRPG


