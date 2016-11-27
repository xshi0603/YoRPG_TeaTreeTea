# YoRPG_TeaTreeTea
YoRPG project APCS1

## YoRPG Final Version Details:

### Super Class : Character 

Contains subclasses Hero and Monster that further divides the roles being called in this game.

All characters inherit these attributes, although not all attributes will be set. For example, Monsters do not have a level.

    * protected String name;
    * protected int HP;
    * protected int strength;
    * protected int defense;
    * protected double attackRating;
    * protected double EXP;
    * protected int LVL;

All characters inherit these methods, although not all methods will be used. For example, Monsters will not use getLVL().

    * Boolean isAlive()
    * int getHP()
    * int getStrength()
    * int getDefense()
    * String getName()
    * double getEXP()
    * double getAttackRating()
    * int lowerHP()
    * double getLVL()
    * int attack
    * abstract void specialize()
    * abstract void normalize() 


#### Sub Class : Hero 

Contains subclasses or roles that classify as protagonists. Protagonists attack the monsters. Heros can level up and gain additional defense and damage.

1. Warrior 

   * has average stats

2. Knight

   * has the highest defense

3. Mage

   * has high attackscaling

4. Rouge

   * low health but has the highest attack scaling

5. Explorer

   * has the highest health

#### Sub Class : Monster

Contains subclasses or roles that classify as antagonists. Antagonists attack the heroes. Monsters have exp which they give to the heroes when defeated.

1. Paladin

   * has bunches of health and gives tons of exp
   
2. Ranger

   * gives a moderate amount of exp and is moderately dangerous

3. Slime

   * gives a moderate amount of exp and is moderately dangerous