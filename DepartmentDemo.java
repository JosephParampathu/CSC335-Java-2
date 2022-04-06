/*
Name: Joseph Parampathu
Date: November 25, 2021
Assignment: CSC 335, Unit 11 Case Problems
Class Purpose: This is a class that demonstrates the department class and the many employee subclasses that make it up
It provides the user information about the employees of the department
*/
import java.util.*;

public class DepartmentDemo
{
  //set the keyboard input and instantiate variables
  private final static Scanner INPUT = new Scanner(System.in);

  //the main method which starts the program, prompts for the department information, and displays the department information
  public static void main(String[] args)
  {
    Department myDepartment = new Department(askDepartmentName(), createDepartmentEmployees());
    displayDepartment(myDepartment);
  }

  //Asks the user to set the department name
  public static String askDepartmentName()
  {
    String responseName = "";
    System.out.println("Enter the department's name: >> ");
    responseName = INPUT.nextLine();
    return responseName;
  }

  //method asks for the number of employees in the department
  public static int askDepartmentSize()
  {
    int responseSize = -1;
    while(responseSize < 0)
    {
      System.out.println("Enter the number of employees in the department (positive integer): >> ");
      try
      {
        responseSize = INPUT.nextInt();
      }
      catch (Exception e)
      {
        INPUT.nextLine();
      }
    }
    INPUT.nextLine();
    return responseSize;
  }

  //This method asks for the employee's id
  public static String askEmployeeId()
  {
    String id = "";
    System.out.println("Enter the employee's ID: >> ");
    id = INPUT.nextLine();
    return id;
  }

  //method asks the user for the employee's first name
  public static String askEmployeeFirstName()
  {
    String first = "";
    System.out.println("Enter the employee's First Name: >> ");
    first = INPUT.nextLine();
    return first;
  }

  //method asks the user for the employee's last name
  public static String askEmployeeLastName()
  {
    String last = "";
    System.out.println("Enter the employee's Last Name: >> ");
    last = INPUT.nextLine();
    return last;
  }

  //Thie method asks the user to enter a type of employee pay
  public static String askEmployeeType()
  {
    String responseType = "";
    System.out.println("Enter the employee's pay type (Salary, Hourly, or Contract): >> ");
    responseType = INPUT.nextLine();
    while(!(responseType.equals("Salary")) && !(responseType.equals("Hourly")) && !(responseType.equals("Contract")))
    {
      System.out.println("Enter the employee's pay type (Salary, Hourly, or Contract): >> ");
      responseType = INPUT.nextLine();
    }
    return responseType;
  }

  //This method calls the other methods to request employee information for each employee in the department
  public static ArrayList<Employee> createDepartmentEmployees()
  {
    ArrayList<Employee> departmentEmployees = new ArrayList<Employee>();
    int size = askDepartmentSize();
    for (int i = 0; i < size; i++)
    {
      switch (askEmployeeType())
      {
        case "Salary":
          departmentEmployees.add(new SalaryEmployee(askEmployeeId(), askEmployeeFirstName(), askEmployeeLastName(), askEmployeePay("Salary")));
          break;
        case "Hourly":
          departmentEmployees.add(new HourlyEmployee(askEmployeeId(), askEmployeeFirstName(), askEmployeeLastName(), askEmployeePay("Hourly")));
          break;
        case "Contract":
          departmentEmployees.add(new ContractEmployee(askEmployeeId(), askEmployeeFirstName(), askEmployeeLastName(), askEmployeePay("Contract"), askExpectedTotalHours()));
      }
    }
    return departmentEmployees;
  }

  //This method displays all the information about the department
  public static void displayDepartment(Department dep)
  {
    System.out.println("Department Name: " + dep.getName());
    System.out.println("Employees: \n");
    int i = 1;
    for (Employee eachEmployee : dep.getEmployees())
    {
      System.out.println("\n\t" + i + ": " + "\n\t\tID: " + eachEmployee.getId() + "\n\t\tFirst Name: " +
      eachEmployee.getFirstName() + "\n\t\tLast Name: " + eachEmployee.getLastName() + "\n\t\tPay: " + eachEmployee.getPayInfo());
      i++;
    }
  }

  //This method asks for the employee's payment amount
  public static double askEmployeePay(String type)
  {
    double responsePay;
    System.out.println("Enter the employee's total " + type + " pay: >> ");
    while(!INPUT.hasNextDouble())
    {
      System.out.println("Please enter a valid number: >> ");
      INPUT.nextLine();
      System.out.println("Enter the employee's total " + type + " pay: >> ");
    }
    responsePay = Double.parseDouble(INPUT.nextLine());
    return responsePay;
  }

  //This method prompts the user to input the expected total hours for contract employees' jobs to ensure they are paid at least the minimum per hour
  public static int askExpectedTotalHours()
  {
    int totalHours;
    System.out.println("Please enter the expected number of hours for the contract: >> ");
    while(!INPUT.hasNextInt())
    {
      System.out.println("Please enter a valid positive integer: >> ");
      INPUT.nextLine();
      System.out.println("Please enter the expected number of hours for the contract: >> ");
    }
    totalHours = Integer.parseInt(INPUT.nextLine());
    if (totalHours < 0)
    {
      totalHours = 0;
    }
    return totalHours;
  }
}
