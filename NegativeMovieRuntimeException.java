/*
Name: Joseph Parampathu
Date: November 28, 2021
Assignment: CSC 335, Unit 12 Case Problems
Class Purpose: This class provides an exception to catch a runtime that is negative

*/

public class NegativeMovieRuntimeException extends Exception
{
  public NegativeMovieRuntimeException()
  {
    super("Movie runtime cannot be negative.");
  }

}
