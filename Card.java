/**
 * Name: Joseph Parampathu
 * Date: 11/07/21
 * Assignment: Unit 9 Case Problem 2
 *
 * Purpose (Class Description): This will create the class to set the cards for the matching game
 **/
import java.util.*;

public class Card
{
    //This enumerator creates the card values
    public enum CardValues {SPIDERS, PUMPKINS, GHOSTS, WITCHES, GOBLINS, SKELETONS, MONSTERS, GHOULS, BEASTS, WARLOCKS};
    final static int NUM_OF_CARD_TYPES = 10;

    //this instantiates the variables for the class
    private CardValues value;
    private boolean isShown;

    //Constructor method to set the cards
    public Card(CardValues val)
    {
      setValue(val);
      hide();
    }

    //Getter method for the value returns card value
    public CardValues getValue()
    {
      return value;
    }

    //Setter method to set cardvalue based on passed value
    public void setValue(CardValues cardVal)
    {
      value = cardVal;
    }

    //Getter method for isShown tells if the card is displayed or not
    public boolean getIsShown()
    {
      return isShown;
    }

    //Setter method for isShown sets the value to true or false
    public void setIsShown(boolean shown)
    {
      isShown = shown;
    }

    //method that sets isShown to true when a card is displayed
    public void show()
    {
      isShown = true;
    }

    //Method that sets isShown to false when a card is not displayed
    public void hide()
    {
      isShown = false;
    }
}
