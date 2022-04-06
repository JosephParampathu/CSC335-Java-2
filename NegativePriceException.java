/*
Name: Joseph Parampathu
Date: November 28, 2021
Assignment: CSC 335, Unit 12 Case Problems
Class Purpose: This class provides an exception to catch a price that is negative

*/

public class NegativePriceException extends Exception
{
  public NegativePriceException()
  {
    super("Price cannot be negative.");
  }

}
