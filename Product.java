/**
 * Name: Joseph Parampathu
 * Date: 11/07/21
 * Assignment: Unit 9 Case Problem 1
 *
 * Purpose (Class Description): A class called product that gets and sets information for each product in the store.
 */
 import java.util.*;

 public class Product
 {
   //The insntance variables for id, name, cost, and price sold
   private String id;
   private String name;
   private double cost;
   private double price;

   //This method constructs the product object with user input
   public Product(String identity, String itemName, double itemCost, double itemPrice)
   {
     //Calls the setters to set each parameter
     setId(identity);
     setName(itemName);
     setCost(itemCost);
     setPrice(itemPrice);
   }

   //"Setters" and "Getters"

   //This method sets the ID equal to the passed string value
   public void setId(String itemId)
   {
     id = itemId;
   }

   //This method returns the item's id
   public String getId()
   {
     return id;
   }

   //This method sets the item's name with the input provided by the user
   public void setName(String itemNm)
   {
     name = itemNm;
   }

   //This method returns the answer
   public String getName()
   {
     return name;
   }

   //This method sets the cost of the item equal to the passed double
   public void setCost(double itemCostPassed)
   {
     cost = itemCostPassed;
   }

   //This method returns the item's cost
   public double getCost()
   {
     return cost;
   }

   //This method sets the item's price using the value passed to the setter
   public void setPrice(double itemPricePassed)
   {
     price = itemPricePassed;
   }

   //This method returns the item price
   public double getPrice()
   {
     return price;
   }

   //This method returns a string representation of the product
   public String getProductsDisplay()
   {
     String productText;
     productText = name + " (" + id + ") was bought for $" + cost + " and sells for $" + price;
     return productText;
   }

 }
