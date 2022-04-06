/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: This is a class that sets the department filled with employees
*/
import java.util.*;

public class Department
{
  //instance variables
  private String name;
  private ArrayList<Employee> employees = new ArrayList<Employee>();

  //constructor method to create the department
  public Department(String departmentName, ArrayList<Employee> departmentEmployees)
  {
    setName(departmentName);
    setEmployees(departmentEmployees);
  }

  //Method that sets the name of the department
  public void setName(String depName)
  {
    name = depName;
  }

  //method that returns the name of the department
  public String getName()
  {
    return name;
  }

  //Method that sets the employees in the department
  public void setEmployees(ArrayList<Employee> depEmployees)
  {
    employees = depEmployees;
  }

  //method that returns the employees in the department
  public ArrayList<Employee> getEmployees()
  {
    return employees;
  }
}
