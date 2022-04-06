/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: This is a variation of employee for employees who are paid in salary
*/
public class SalaryEmployee extends Employee
{
  //instantiate variables
  private final double MINIMUM_SALARY = 1.00;
  private double salary;

  //constructor method to create salaried employees
  public SalaryEmployee(String identity, String first, String last, double employeeSalary)
  {
    //calls the superclass's constructor
    super(identity, first, last);
    setSalary(employeeSalary);
  }

  //this method returns the salary amount
  public double getSalary()
  {
    return salary;
  }

  //this method sets the salary to the passed value
  public void setSalary(double employeeSal)
  {
    if (employeeSal < MINIMUM_SALARY)
    {
      employeeSal = MINIMUM_SALARY;
    }
    salary = employeeSal;
  }

  //this method returns the pay information for the salaried employee
  public String getPayInfo()
  {
    String payMessage = "$" + salary + " per year";
    return payMessage;
  }
}
