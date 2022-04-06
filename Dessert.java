/**
 * Name: Joseph Parampathu
 * Date: 11/28/2021
 * Assignment: Unit 12 Case Problem 2
 *
 * Purpose (Class Description): A class called Dessert that is the child of the MenuItem class and includes a constructor with parameter.
 */

 public class Dessert extends MenuItem
 {
   //Constructor method with super constructor inside to call the parent class constructor
   public Dessert(String dessertName, double dessertPrice) throws NegativePriceException
   {
     super(dessertName, dessertPrice, MenuValues.DESSERT);
   }

 }
