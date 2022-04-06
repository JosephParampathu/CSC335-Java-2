/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: This is a variation of employee for employees who are paid in hourly wages
*/
public class HourlyEmployee extends Employee
{
  //instantiate variables
  public static final double MINIMUM_HOURLY_PAY = 0.05;
  private double hourlyPay;

  //constructor method to create hourly employees
  public HourlyEmployee(String identity, String first, String last, double employeeHourly)
  {
    //calls the superclass's constructor
    super(identity, first, last);
    setHourlyPay(employeeHourly);
  }

  //this method returns the hourly amount
  public double getHourlyPay()
  {
    return hourlyPay;
  }

  //this method sets the hourly amount
  public void setHourlyPay(double empHourly)
  {
    if (empHourly < MINIMUM_HOURLY_PAY)
    {
      empHourly = MINIMUM_HOURLY_PAY;
    }
    hourlyPay = empHourly;
  }

  //this method returns the pay information for the hourly employee
  public String getPayInfo()
  {
    String payMessage = "$" + hourlyPay + " per hour";
    return payMessage;
  }
}
