/* 
Team TreeTeaTree: Queenie Xiang, Xing Tao Shi, Kevin Bao 
APCS1 pd1
HW30 -- Ye Olde Role Playing Game
2016-11-16
*/ 

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
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Character player;  //Is it man or woman?
    private Monster smaug; //Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;

    private Character role;
    private int selection;

    private Character a = new Warrior("");
    private Character b = new Mage("");
    private Character c = new Rogue(""); 
    private Character d = new Explorer("");
    private Character e = new Knight("");
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
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	//Introduction
	s = "Intrepid player, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	
	//player = role; 
	s = "\n Choose your class of player: \n";
	s += "\t1: Warrior\n";
	
	s += "\t2: Mage\n";

	s += "\t3: Rogue\n";

	s += "\t4: Explorer\n";

	s += "\t5: Knight\n";

	s += "Selection: ";
	System.out.print ( s );

	try {
	    selection = Integer.parseInt( in.readLine() );
	    
	    if ( selection == 1 ) {
		player = new Warrior(name);
	    }
	    if ( selection == 2 ) {
	        player = new Mage(name);
	    }
	    if ( selection == 3 ) {
	        player = new Rogue(name);
	    }
	    if ( selection == 4 ) {
	        player = new Explorer(name);
	    }
	    if ( selection == 5 ) {
	        player = new Knight(name);
	    }
	   
	    System.out.println("\n" + player.about(player) + "\n");
	   
	}
    
	catch ( IOException e ) {}
	    
	
	s = "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }


	

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Character player has been initialized
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
	    System.out.println( "\nLo, yonder monster approacheth!" + "\n" );

	    smaug = new Monster();
	    System.out.println( "Monster's Stats:" );
	    System.out.println( smaug.about(smaug) ); 
	    while( (((Character)smaug).isAlive())  && (((Character)player).isAlive()) ) {

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
		    ((Character)player).specialize();
		else
		    ((Character)player).normalize();

		d1 = ((Character)player).attack( smaug );
		d2 = ((Character)smaug).attack( player );

		System.out.println( "\n" + ((Character)player).getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Olde Monster smacked " + ((Character)player).getName() +
				    " for " + d2 + " points of damage.");

		if ( ((Character)player).getHealth() > 0 ) {
		    System.out.println("\n" + ((Character)player).getName() + "'s Current HP: " + ((Character)player).getHealth());
		    System.out.println("\n" + "Monster's Current HP: " + ((Monster)smaug).getHealth());
		}
		
	    }//end while

	    //option 1: you & the monster perish
	    if ( !((Character)smaug).isAlive() && !((Character)player).isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !((Character)smaug).isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !((Character)player).isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args )
    {
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


