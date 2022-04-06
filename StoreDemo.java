/**
 * Name: James Sekcienski
 * Date: 10/30/21
 * Assignment: Unit 9 Case Problem 1
 *
 * Purpose (Class Description): Allows the user to view and sort the products of a store.
 */

import java.util.*;

public class StoreDemo {
  public enum SortChoices {ID, NAME, COST, PRICE};

  private static final Scanner INPUT = new Scanner(System.in);

  /**
   * Takes in an array of arguments
   * Creates the initial products for a store.
   * Allows the user to interact with the products in the store that is created.
   */
  public static void main(String[] args) {
    // Creates the store with an initial list of products
    ProductList storeProducts = new ProductList();

    // Prints out the list of products in the store to start
    System.out.println(storeProducts.getProductsDisplay());

    // Continues to ask user how they want to sort the list until they decide to quiz
    int userResponse = -1;
    while(userResponse != 0) {
      userResponse = askUserHowToDisplay();
      handleUserDisplayResponse(userResponse, storeProducts);
    }
  }

  /**
   * Shows the user options for how to sort and display the products.
   * Continues to ask the user how they want the products displayed until a valid choice is provided.
   * @return the option for how the user wants to sort the product
   */
  public static int askUserHowToDisplay() {
    // Display menu of choices to user
    int numOfChoices = SortChoices.values().length;
    System.out.println("How would you like to display the products for this store?");
    for (int i = 0; i < numOfChoices; i++) {
      System.out.println("\t" + (i + 1) + ": " + SortChoices.values()[i]);
    }
    System.out.println("Enter 0 to QUIT");

    // Get user response.  Repeat until a valid input is provided
    int userResponse = -1;
    while (userResponse < 0 || userResponse > numOfChoices) {
      String answer = INPUT.nextLine();
      try {
        int numericAnswer = Integer.parseInt(answer);
        if (numericAnswer < 0 || numericAnswer > numOfChoices) {
          System.out.println("You must enter a choice from the menu or 0 to quit.  Try again.");
        } else {
          userResponse = numericAnswer;
        }
      } catch (NumberFormatException e) {
        System.out.println("You must enter a number.  Try again.");
      }
    }

    return userResponse;
  }

  /**
   * This will sort and display the products in the ProductList based on the displayChoice.  If it is -1, it displays a quit message.
   * @param displayChoice Value corresponds to index of the SORT_CHOICE for how to display the products.  A value of 0 means display the exit message
   * @param products The ProductList that is being sorted and displayed based on the displayChoice
   */
  public static void handleUserDisplayResponse(int displayChoice, ProductList products) {
    if (displayChoice == 0) {
      System.out.println("Thank you for taking a look at the products!");
    } else {
      SortChoices[] choices = SortChoices.values();

  
      switch(choices[(displayChoice - 1)]) {
        case ID:
          products.sortProductsById();
          break;
        case NAME:
          products.sortProductsByName();
          break;
        case COST:
          products.sortProductsByCost();
          break;
        case PRICE:
          products.sortProductsByPrice();
          break;

      }

      System.out.println(products.getProductsDisplay());
      System.out.println();
    }

  }
}
