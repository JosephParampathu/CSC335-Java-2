/**
 * Name: James Sekcienski
 * Date: 10/30/21
 * Assignment: Unit 9 Case Problem 2
 *
 * Purpose (Class Description): This will allow a user to play a Matching Game on their own and see how many rounds it takes them to find all the pairs.
 */
import java.util.*;

public class GameDemo {
  private final static Scanner INPUT = new Scanner(System.in);

  /**
   * This welcomes the play to the Matching Game, has the user play the game, and then thanks them for playing.
   * @param args Takes in arguments from the console.  They aren't used in this method.
   */
  public static void main(String[] args) {
    displayIntro();

    playGame();

    System.out.println("Thanks for playing!");
  }

  /**
   * This prints out messages to introduce the matching game
   */
  public static void displayIntro() {
    System.out.println("Welcome to the Matching Game!!!");
    System.out.println("Your objective is to find all the matches in as few guesses as possible.");
    System.out.println("Let's get started!");
  }

  /**
   * This creates a new matching game by making a new Grid.
   * User will continue to play until all matches are revealed.
   * It will end with letting the user know how many rounds it took them to win.
   */
  public static void playGame() {
    Grid matchingGame = new Grid();
    System.out.println(matchingGame.getGridDisplay());
    System.out.println();

    int numOfRoundsPlayed = 0;
    while (matchingGame.hasCards()) {
      playRound(matchingGame);
      numOfRoundsPlayed++;
    }

    System.out.println("You found all matches in " + numOfRoundsPlayed + " rounds.");
  }

  /**
   * This will handle playing one round of the matching game.
   * This includes the user revealing two valid cards and then handling whether or not the cards were a match.
   * @param matchingGame The Grid that is being used for playing the current game
   */
  public static void playRound(Grid matchingGame) {
    int cardNum1 = askUserForCardToShow(matchingGame);
    int cardNum2 = askUserForCardToShow(matchingGame);

    handleSelectedCards(matchingGame, cardNum1, cardNum2);
    System.out.println(matchingGame.getGridDisplay());
  }

  /**
   * This will ask the user for the number of the card they would like to show.
   * If they enter an invalid choice, it will prompt them again until a valid choice is entered.
   * @param matchingGame The Grid that represents the current game
   * @return The valid position of the card the user wants to show
   */
  public static int askUserForCardToShow(Grid matchingGame) {
    System.out.println("Enter the card number you would like to reveal");
    String userResponse = INPUT.nextLine();
    while (true) {
      try {
        int cardNum = Integer.parseInt(userResponse) - 1;
        if (matchingGame.getCard(cardNum) != null && !matchingGame.isCardShown(cardNum)) {
          matchingGame.showCard(cardNum);
          System.out.println(matchingGame.getGridDisplay());
          return cardNum;
        } else {
          System.out.println("You must enter a number left in the grid.  Try again.");
          userResponse = INPUT.nextLine();
        }
      } catch (NumberFormatException e) {
        System.out.println("You must enter a number in the grid.  Try again.");
        userResponse = INPUT.nextLine();
      }
    }
  }

  /**
   * This method will check to see if the two selected cards are a match and print out the relevant message.
   * - If they are a match it will also remove those cards from the Grid.
   * - If they are not a match it will hide the cards again.
   * @param matchingGame The Grid that represents the current game
   * @param cardNum1 The position of the first selected card
   * @param cardNum2 The position of the second selected card
   */
  public static void handleSelectedCards(Grid matchingGame, int cardNum1, int cardNum2) {
    if (matchingGame.getCardValue(cardNum1) == matchingGame.getCardValue(cardNum2)) {
      System.out.println("Match found!!!");
      matchingGame.removeCard(cardNum1);
      matchingGame.removeCard(cardNum2);
    } else {
      System.out.println("Not a match");
      matchingGame.hideCard(cardNum1);
      matchingGame.hideCard(cardNum2);
    }
    System.out.println();
  }
}
