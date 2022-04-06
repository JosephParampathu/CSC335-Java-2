/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: This employee abstract class sets the basic structure and methods for all employee variations
*/
public abstract class Employee
{
  //Instance variables
  private String id;
  private String firstName;
  private String lastName;

  //Constructor method
  public Employee(String identity, String first, String last)
  {
    setId(identity);
    setFirstName(first);
    setLastName(last);
  }

  //this method returns the id
  public String getId()
  {
    return id;
  }

  //method that sets the id to the passed parameter
  public void setId(String employeeIdentity)
  {
    id = employeeIdentity;
  }

  //method that returns the first name value
  public String getFirstName()
  {
    return firstName;
  }

  //method that sets the first name value to the passed parameter
  public void setFirstName(String employeeFirst)
  {
    firstName = employeeFirst;
  }

  //method that returns the last name value
  public String getLastName()
  {
    return lastName;
  }

  //method that sets the last name value to the passed parameter
  public void setLastName(String employeeLast)
  {
    lastName = employeeLast;
  }

  //Abstract method the returns a string wtih information for how much the employee is paid
  public abstract String getPayInfo();
}
