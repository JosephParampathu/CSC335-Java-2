/**
 * Name: Joseph Parampathu
 * Date: 11/09/21
 * Assignment: Unit 10 Case Problem 1
 *
 * Purpose (Class Description): A class called CardGame that is a child of Game and includes a constructor and a method to return a string representation of the game .
 */

 public class CardGame extends Game
 {
   //instantiates the vairables
   boolean usesStandardCardDeck;

   //Constructor method with super constructor inside to call the parent class constructor
   public CardGame(String gameName, int minNum, int maxNum, boolean usesStandard)
   {
     super(gameName, minNum, maxNum, GameValues.CARD);
     setUsesStandardCardDeck(usesStandard);
   }

   //This sets the boolean if the game type uses a standard deck based on the user response
   public void setUsesStandardCardDeck(boolean isStandard)
   {
     usesStandardCardDeck = isStandard;
   }

   //This getter returns the value of whether the game uses a standard deck or not
   public boolean getUsesStandardCardDeck()
   {
     return usesStandardCardDeck;
   }

   //This overrides the parent's toString method and creates a string representation of the Card Game
   @Override
   public String toString()
   {
     String text;
     text = super.toString();
     if (usesStandardCardDeck)
     {
       text += "\n This game is playable with a standard deck of cards.";
     }
     else
     {
       text += "\n You will need to purchase the cards for this game.";
     }
     return text;
   }

 }
