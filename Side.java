/**
 * Name: Joseph Parampathu
 * Date: 11/28/2021
 * Assignment: Unit 12 Case Problem 2
 *
 * Purpose (Class Description): A class called Side that is the child of the MenuItem class and includes a constructor with parameter.
 */

 public class Side extends MenuItem
 {
   //Constructor method with super constructor inside to call the parent class constructor
   public Side(String sideName, double sidePrice) throws NegativePriceException
   {
     super(sideName, sidePrice, MenuValues.SIDE);
   }

 }
