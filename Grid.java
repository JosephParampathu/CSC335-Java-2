/**
 * Name: Joseph Parampathu
 * Date: 11/07/21
 * Assignment: Unit 9 Case Problem 2
 *
 * Purpose (Class Description): This will set the grid for the user to play the matching game.
 */
import java.util.*;

public class Grid
{
  //Sets the number of pairs in the game to be found
  static final int NUM_OF_PAIRS = 2;

  //These constants are for the size of teh grid  as four columns, the columns and NUM_OF_PAIRS are used to determine the number of rows
  static final int COLUMNS = 4;
  static final int ROWS = 1 + (int)(NUM_OF_PAIRS/COLUMNS);

  //instantiates the card variable
  private Card[][] cards;

  //Constructor method to set the grid
  public Grid()
  {
    generateCards();
    shuffle();
  }

  //Generate Cards method to initialize the cards as an array
  public void generateCards()
  {
    Card[][] cards = new Card[COLUMNS][ROWS];

    int column_index = 0;
    int row_index = 0;

    //This gridPosition will be the specific point in the matrix where we are inserting a card. This iterates through each position to generate a card
    int gridPosition = 0;
    while (gridPosition < 2*NUM_OF_PAIRS)
    {
      //Adds pairs in order, filling two at a time in adjacent columns
      for (Card.CardValues choiceOfCard : Card.CardValues.values())
        {
          try
          {
          column_index = gridPosition / ROWS;
          row_index = gridPosition / COLUMNS;
          cards[column_index][row_index] = new Card(choiceOfCard);
          cards[column_index + 1][row_index] = cards[column_index][row_index];
          gridPosition = gridPosition + 2;
          }
          catch (ArrayIndexOutOfBoundsException e)
          {
            continue;
          }
        }
    }

    //Shuffles the grid
    shuffle();
  }

  //This method shuffles the grid
  public void shuffle()
  {
    for (Card[] eachCardRow : cards)
    {
      for (Card eachCard : eachCardRow)
      {
        if(eachCard != null)
        {
          int randomFirst = (int)(Math.random()*(Card.NUM_OF_CARD_TYPES + 1));
          int randomSecond = (int)(Math.random()*(Card.NUM_OF_CARD_TYPES + 1));
          Card temp = eachCard;
          eachCard = cards[randomSecond][randomFirst];
          cards[randomSecond][randomFirst] = temp;
        }
      }
    }
  }

  //Overloaded shuffle which takes the parameter for how many times to shuffle the grid
  public void shuffle(int shuffleTimes)
  {
    while (shuffleTimes > 0)
    {
      shuffle();
      shuffleTimes--;
    }
  }

  //Method shows which card is in the passed position
  public Card getCard(int cardNumber)
  {
    int column_index = 0;
    int row_index = 0;
    if (cardNumber > 2*NUM_OF_PAIRS)
    {
      return null;
    }
    else
    {
      column_index = cardNumber / ROWS;
      row_index = cardNumber / COLUMNS;
      return cards[column_index][row_index];
    }
  }

  //This method shows the card in the position selected
  public void showCard(int cardToShow)
  {
    int column_index = 0;
    int row_index = 0;
    if (cardToShow <= 2*NUM_OF_PAIRS)
    {
      column_index = cardToShow / ROWS;
      row_index = cardToShow / COLUMNS;
      cards[column_index][row_index].show();
    }
  }

//This method returns whether a passed card is shown or not
  public boolean isCardShown(int cardToCheck)
  {
    boolean isThisCardShown = false;
    int column_index = 0;
    int row_index = 0;
    if (cardToCheck <= 2*NUM_OF_PAIRS)
    {
      column_index = cardToCheck / ROWS;
      row_index = cardToCheck / COLUMNS;
      isThisCardShown = cards[column_index][row_index].getIsShown();
    }
    return isThisCardShown;
  }

  //This method hides the card in the position selected
  public void hideCard(int cardToHide)
  {
    int column_index = 0;
    int row_index = 0;
    if (cardToHide <= 2*NUM_OF_PAIRS)
    {
      column_index = cardToHide / ROWS;
      row_index = cardToHide / COLUMNS;
      cards[column_index][row_index].hide();
    }
  }

  //This method removes the card at the position passed
  public void removeCard(int cardToRemove)
  {
    int column_index = 0;
    int row_index = 0;
    if (cardToRemove <= 2*NUM_OF_PAIRS)
    {
      column_index = cardToRemove / ROWS;
      row_index = cardToRemove / COLUMNS;
      cards[column_index][row_index].hide();
    }
  }

  //This method checks if there are cards in the grid
  public boolean hasCards()
  {
    boolean isDeckNull = true;
    for (Card[] eachRowOfCards : cards)
    {
      for (Card eachOfCards : eachRowOfCards)
      {
        if (eachOfCards != null)
        {
          isDeckNull = false;
          break;
        }
      }
    }
    return isDeckNull;
  }

  //This method prints out the graphical display of the card game
  public String getGridDisplay()
  {
    String gridMessage = "";
    for (Card[] x : cards)
      {
        for (Card y : x)
          {
            if(y != null)
            {
              gridMessage += y.getValue() + " | ";
            }
            else
            {
              gridMessage += " X | ";
            }
          }
        gridMessage += "\n";
      }
    return gridMessage;
  }

  //This takes in a number and returns the value of the card on the grid that matches that number
  public Card getCardValue(int NumberedCard)
  {
    int column_index = 0;
    int row_index = 0;
    if (NumberedCard > 2*NUM_OF_PAIRS)
    {
      return null;
    }
    else
    {
      column_index = NumberedCard / ROWS;
      row_index = NumberedCard / COLUMNS;
      return cards[column_index][row_index];
    }
  }
}
