/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: This is a variation of employee for employees who are are paid on contract/contingent basis
*/
import java.util.*;

public class ContractEmployee extends Employee
{
  //instantiate pay variables
  private double totalPay;
  private int expectedTotalHours;

  //constructor method to create contract employees
  public ContractEmployee(String identity, String first, String last, double contractTotalPay, int expectedHours)
  {
    //calls the superclass's constructor
    super(identity, first, last);
    setExpectedTotalHours(expectedHours);
    setTotalPay(contractTotalPay);
  }

  //this method asks what the expected hours are to make sure the employee is paid the minimum wage equivalent
  public void setExpectedTotalHours(int expectedWorkHours)
  {
    expectedTotalHours = expectedWorkHours;
  }

  //this method returns the contract amount
  public double getTotalPay()
  {
    return totalPay;
  }

  //this method sets the contract amount
  public void setTotalPay(double empTotalPay)
  {
    if (empTotalPay < expectedTotalHours*HourlyEmployee.MINIMUM_HOURLY_PAY)
    {
      empTotalPay = expectedTotalHours*HourlyEmployee.MINIMUM_HOURLY_PAY;
    }
    totalPay = empTotalPay;
  }

  //this method returns the pay information for the hourly employee
  public String getPayInfo()
  {
    String payMessage = "$" + totalPay + " for fulfilling the terms of the contract";
    return payMessage;
  }
}
