/**
 * Name: Joseph Parampathu
 * Date: 11/28/2021
 * Assignment: Unit 12 Case Problem 2
 *
 * Purpose (Class Description): A class called MenuItem that is the base class for menu items and includes a constructor and a method to return a string representation of the menuitem.
 */

 public class MenuItem
 {
   //This enumerator creates the game values
   public enum MenuValues {APPETIZER, ENTREE, SIDE, DESSERT};

   //This instantiates the variables
   private String name;
   private double price;
   private MenuValues type;

   //This is the constructor method that takes each of the variables and uses the setters to pass the values
   public MenuItem(String itemName, double itemPrice, MenuValues itemType) throws NegativePriceException
   {
     setName(itemName);
     setPrice(itemPrice);
     setType(itemType);
   }

   //The setter takes in a string and sets the name equal to it
   public void setName(String nameOfItem)
   {
     name = nameOfItem;
   }

   //The getter returns the name of the game
   public String getName()
   {
     return name;
   }

   //The setter takes in a double and sets the price equal to it
   public void setPrice(double priceOfItem) throws NegativePriceException
   {
     price = priceOfItem;
     if (price < 0)
     {
       throw new NegativePriceException();
     }
   }

   //The getter returns the price
   public double getPrice()
   {
     return price;
   }

   //The setter takes in a menu enum value and sets the type equal to it
   public void setType(MenuValues typeOfItem)
   {
     type = typeOfItem;
   }

   //The getter returns the menu type
   public MenuValues getType()
   {
     return type;
   }

   //This creates the string representation of the MenuItem which is a message showing the basic details
   public String toString()
   {
     String message;
     message = name + " (" + type.toString().toLowerCase() + ") sells for $" + price;
     return message;
   }

 }
