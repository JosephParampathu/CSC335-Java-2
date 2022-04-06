/**
 * Name: Joseph Parampathu
 * Date: 11/28/2021
 * Assignment: Unit 12 Case Problem 2
 *
 * Purpose (Class Description): Allows the user to place an order consisting of an appetizer,
 * entree, two sides, and dessert.
 */

import java.util.*;

public class MenuDemo
{
  private static final Scanner INPUT = new Scanner(System.in);

  public static void main(String[] args)
  {
    // Creates the available menu items
    Appetizer[] appetizers = createAppetizers();
    Entree[] entrees = createEntrees();
    Side[] sides = createSides();
    Dessert[] desserts = createDesserts();

    System.out.println("Welcome to the Food Lovers Restaurant.");
    System.out.println("Our meals include one appetizer, one entree, two sides, and one dessert.");

    MenuItem[] mealItems = askForMealItems(appetizers, entrees, sides, desserts);

    System.out.println("You have ordered the following: ");
    displayMenuItems(mealItems);
  }

  /**
   * Creates array of appetizers and returns them
   * @return Array of appetizers
   */
  public static Appetizer[] createAppetizers()
  {
    Appetizer[] appetizers = new Appetizer[3];

    //This uses the constructor to create 3 appetizers
    try
    {
      appetizers[0] = new Appetizer("Spiced Olives", 1.50);
      appetizers[1] = new Appetizer("Summer Rolls", 3.50);
      appetizers[2] = new Appetizer("Buffalo Sprouts", 2.00);
    }
    catch (NegativePriceException error)
    {
      new NegativePriceException();
    }
    return appetizers;
  }

  /**
   * Creates array of entrees and returns them
   * @return Array of entrees
   */
  public static Entree[] createEntrees()
  {
    Entree[] entrees = new Entree[4];

    //This uses the constructor to create 4 entrees
    try
    {
      entrees[0] = new Entree("Stir Fry", 2.50);
      entrees[1] = new Entree("Dumplings", 2.00);
      entrees[2] = new Entree("Rice with Cauliflower Curry", 4.00);
      entrees[3] = new Entree("Falafel", 3.00);
    }
    catch (NegativePriceException error)
    {
      new NegativePriceException();
    }
    return entrees;
  }

  /**
   * Creates array of sides and returns them
   * @return Array of sides
   */
  public static Side[] createSides()
  {
    Side[] sides = new Side[4];

    //This uses the constructor to create 4 sides
    try
    {
      sides[0] = new Side("Cucumber", 0.50);
      sides[1] = new Side("Black Beans", 1.25);
      sides[2] = new Side("Biscuits", 1.50);
      sides[3] = new Side("Stuffing", 1.00);
    }
    catch (NegativePriceException error)
    {
      new NegativePriceException();
    }
    return sides;
  }

  /**
   * Creates array of desserts and returns them
   * @return Array of desserts
   */
  public static Dessert[] createDesserts()
  {
    Dessert[] desserts = new Dessert[3];

    //This uses the constructor to create 3 desserts
    try
    {
      desserts[0] = new Dessert("Mousse", 1.25);
      desserts[1] = new Dessert("White Chocolate Truffles", 2.50);
      desserts[2] = new Dessert("Apple Crisp", 1.00);
    }
    catch (NegativePriceException error)
    {
      new NegativePriceException();
    }
    return desserts;
  }

  /**
   * Asks user for the menu items they would like to order for their meal
   * @param appetizers Array of available appetizers
   * @param entrees Array of available entrees
   * @param sides Array of available sides
   * @param desserts Array of available desserts
   * @return Array of menu items that were selected for the meal
   */
  public static MenuItem[] askForMealItems(Appetizer[] appetizers, Entree[] entrees,
  Side[] sides, Dessert[] desserts)
  {
    MenuItem[] mealItems = new MenuItem[5];

    System.out.println("Appetizer");
    mealItems[0] = askForMenuItemSelection(appetizers);

    System.out.println("Entree");
    mealItems[1] = askForMenuItemSelection(entrees);

    System.out.println("Side 1");
    mealItems[2] = askForMenuItemSelection(sides);

    System.out.println("Side 2");
    mealItems[3] = askForMenuItemSelection(sides);

    System.out.println("Dessert");
    mealItems[4] = askForMenuItemSelection(desserts);

    return mealItems;
  }

  /**
  This method prompts the user to enter their selected food items from the menu options
   */
  public static MenuItem askForMenuItemSelection(MenuItem[] menuItems)
  {
    MenuItem selectedMenuItem;
    // Prints each of the options
    int i = 0;
    for (MenuItem menuItem : menuItems)
    {
      System.out.println((i + 1) + ": " + menuItem);
      i++;
    }

    //Asks which the user would like to select
    int selection = -1;
    System.out.println("Enter the number of your selection >> ");
    while (selection < 0 || selection > menuItems.length)
    {
      try
      {
        selection = INPUT.nextInt();
        selection--;
        selectedMenuItem = menuItems[selection];
      }
      catch (Exception invalidValue)
      {
        System.out.println("Please enter a valid integer. Enter the number of your selection >> ");
        INPUT.nextLine();
      }
    }
    INPUT.nextLine();

    return menuItems[selection];
  }

  /**
   * Takes in an array of menu items and prints them out.
   * @param menuItems The array of menu items to display
   */
  public static void displayMenuItems(MenuItem[] menuItems)
  {
    for (MenuItem menuItem: menuItems)
    {
      System.out.println(menuItem);
    }
  }
}
